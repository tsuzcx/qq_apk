package com.tencent.aelight.camera.ae.biz.circle.part;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter.RecomAutoTemplateData;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleLoadRecomAutoTemplateDataEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;
import com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCClient;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class AECircleRecomAutoTemplatePart
  extends AECircleBasePart
{
  protected FrameLayout a;
  protected AEEditorLoadingView b;
  private final int f = 2064187521;
  private final int g = 2064187522;
  private int h = 3;
  private ScrollingHeaderLayout i;
  private TextView j;
  private RecyclerView k;
  private NoScrollViewPager l;
  private RecomAutoTemplateAdapter m = null;
  private final Bundle n;
  private Boolean o = Boolean.valueOf(false);
  private boolean p = false;
  private TextView q;
  private TextView r;
  private String s;
  private String t;
  
  public AECircleRecomAutoTemplatePart(AECirclePhotoListLogic paramAECirclePhotoListLogic, Bundle paramBundle)
  {
    super(paramAECirclePhotoListLogic);
    this.n = paramBundle;
    this.c.a(this);
  }
  
  private MetaMaterial a(String paramString)
  {
    try
    {
      paramString = (MetaMaterial)new Gson().fromJson(paramString, MetaMaterial.class);
      return paramString;
    }
    catch (Exception paramString)
    {
      AEQLog.a("AECircleRecomAutoTemplatePart", paramString);
    }
    return (MetaMaterial)((List)new Gson().fromJson(AECircleRecomAutoTemplatePart.DefaultValue.a, new AECircleRecomAutoTemplatePart.7(this).getType())).get(0);
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.next();
        if (localEntry.key.get().equals(paramString1)) {
          return localEntry.value.get();
        }
      }
    }
    return paramString2;
  }
  
  private ArrayList<LocalMediaInfo> a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    int i2 = paramStItemInfo.images.get().size();
    if (i2 == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    int i1 = 0;
    Object localObject2 = new StringBuilder();
    String[] arrayOfString = new String[i2];
    while (i1 < i2)
    {
      if (i1 != 0) {
        ((StringBuilder)localObject2).append(" or ");
      }
      ((StringBuilder)localObject2).append("_id=?");
      arrayOfString[i1] = ((FeedCloudMeta.StImage)paramStItemInfo.images.get().get(i1)).picId.get();
      i1 += 1;
    }
    try
    {
      paramStItemInfo = h().getContentResolver();
      localObject2 = ((StringBuilder)localObject2).toString();
      paramStItemInfo = paramStItemInfo.query((Uri)localObject1, new String[] { "_id", "_data", "_data" }, (String)localObject2, arrayOfString, "date_modified desc");
      if (paramStItemInfo != null)
      {
        while (paramStItemInfo.moveToNext())
        {
          localObject1 = new LocalMediaInfo();
          ((LocalMediaInfo)localObject1)._id = paramStItemInfo.getLong(paramStItemInfo.getColumnIndex("_id"));
          ((LocalMediaInfo)localObject1).path = paramStItemInfo.getString(paramStItemInfo.getColumnIndex("_data"));
          localArrayList.add(localObject1);
        }
        paramStItemInfo.close();
      }
      return localArrayList;
    }
    catch (Exception paramStItemInfo)
    {
      AEQLog.a("AECircleRecomAutoTemplatePart", paramStItemInfo);
    }
    return null;
  }
  
  private void a(List<RecomAutoTemplateAdapter.RecomAutoTemplateData> paramList)
  {
    ThreadManager.getFileThreadHandler().post(new AECircleRecomAutoTemplatePart.6(this, paramList));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((ScrollingHeaderLayout)localObject).getVisibility() != 0) {
        return;
      }
      localObject = new int[1];
      if (paramBoolean)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.i.getBottom() }).setDuration(250L);
        localValueAnimator.addUpdateListener(new AECircleRecomAutoTemplatePart.9(this, (int[])localObject));
        localValueAnimator.addListener(new AECircleRecomAutoTemplatePart.10(this));
        localValueAnimator.start();
        ObjectAnimator.ofFloat(this.i, "alpha", new float[] { 1.0F, 0.0F }).setDuration(250L).start();
        return;
      }
      ((ViewGroup)this.i.getParent()).removeViewAt(0);
    }
  }
  
  private void b(View paramView)
  {
    this.i = ((ScrollingHeaderLayout)paramView.findViewById(2063991264));
    this.a = ((FrameLayout)paramView.findViewById(2063991082));
    this.i.setVisibility(8);
    this.l = ((NoScrollViewPager)paramView.findViewById(2063991266));
    this.j = ((TextView)paramView.findViewById(2063991490));
    this.j.setOnClickListener(new AECircleRecomAutoTemplatePart.1(this));
    ((ImageView)paramView.findViewById(2063991492)).setOnClickListener(new AECircleRecomAutoTemplatePart.2(this));
    this.q = ((TextView)paramView.findViewById(2063991489));
    this.r = ((TextView)paramView.findViewById(2063991491));
    this.k = ((RecyclerView)paramView.findViewById(2063991265));
    paramView = h();
    if (paramView == null) {
      return;
    }
    this.m = new RecomAutoTemplateAdapter(paramView);
    this.m.a(new AECircleRecomAutoTemplatePart.3(this));
    paramView = new LinearLayoutManager(paramView, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.k.setLayoutManager(paramView);
    this.k.setAdapter(this.m);
  }
  
  private void j()
  {
    if ((this.q != null) && (!TextUtils.isEmpty(this.s))) {
      this.q.setText(this.s);
    }
    if ((this.r != null) && (!TextUtils.isEmpty(this.t))) {
      this.r.setText(this.t);
    }
  }
  
  private void k()
  {
    QIPCClientHelper.getInstance().getClient().callServer("qCircleIpcModule", "action_open_clustering_local_photo", null);
    QCircleConfigHelper.b("qqcircle", "recommend_video_template_profile_switch", "1");
    LocalMultiProcConfig.putBool("recommend_video_template_profile_switch", true);
  }
  
  private void l()
  {
    List localList = q();
    if ((localList != null) && (localList.size() > 2))
    {
      this.m.a(localList);
      this.i.setVisibility(0);
      this.k.setVisibility(0);
      j();
      a(localList);
      return;
    }
    QIPCClientHelper.getInstance().getClient().callServer("qCircleIpcModule", "action_clustering_local_photo", null);
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().post(new AECircleRecomAutoTemplatePart.4(this));
  }
  
  private void n()
  {
    ThreadManager.getUIHandler().post(new AECircleRecomAutoTemplatePart.5(this));
  }
  
  private boolean o()
  {
    if (this.o.booleanValue()) {
      return false;
    }
    if (AECameraEntryManager.t(g().getIntent())) {
      return false;
    }
    Bundle localBundle = this.n;
    if (localBundle != null)
    {
      if (localBundle.getBoolean("key_qcircle_from_mid_page", false)) {
        return false;
      }
      return this.n.getBoolean("key_qcircle_publish_smart_block_buster", false);
    }
    return false;
  }
  
  private void p()
  {
    AEQLog.b("AECircleRecomAutoTemplatePart", "initRecomAutoTemplateData");
    if (this.p) {
      return;
    }
    this.p = true;
    if (!o()) {
      return;
    }
    List localList = q();
    if (localList != null)
    {
      if (r())
      {
        if (localList.size() >= this.h)
        {
          this.m.a(localList);
          this.i.setVisibility(0);
          this.k.setVisibility(0);
          j();
          a(localList);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initRecomAutoTemplateData data size = ");
        localStringBuilder.append(localList.size());
        AEQLog.b("AECircleRecomAutoTemplatePart", localStringBuilder.toString());
        return;
      }
      this.i.setVisibility(0);
      this.k.setVisibility(8);
      this.j.setText(h().getText(2064187522));
    }
  }
  
  private List<RecomAutoTemplateAdapter.RecomAutoTemplateData> q()
  {
    Object localObject1 = QCircleUtils.d().getBizUndealMsgBuffer(110);
    if (localObject1 != null) {
      try
      {
        long l1 = LocalMultiProcConfig.getLong("qqcircle_get_photo_cluster_last_time", System.currentTimeMillis());
        if (System.currentTimeMillis() - l1 > QCircleConfigHelper.a("qqcircle", "qqcircle_publish_photo_cluster_expire_time", Integer.valueOf(7)).intValue() * 24 * 60 * 60 * 1000)
        {
          AEQLog.d("AECircleRecomAutoTemplatePart", "parseRecomData data expired");
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = new FeedCloudRead.StGetFeedListRsp();
        ((FeedCloudRead.StGetFeedListRsp)localObject2).mergeFrom((byte[])localObject1);
        localObject1 = ((FeedCloudRead.StGetFeedListRsp)localObject2).vecFeed.get();
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (FeedCloudMeta.StFeed)((List)localObject1).get(0);
          localObject1 = new QQCircleDitto.StCircleDittoDataNew();
          ((QQCircleDitto.StCircleDittoDataNew)localObject1).mergeFrom(((FeedCloudMeta.StFeed)localObject2).dittoFeed.dittoDataNew.get().toByteArray());
          this.s = ((QQCircleDitto.StItemContainer)((QQCircleDitto.StCircleDittoDataNew)localObject1).itemContainter.get()).title.get();
          this.t = ((QQCircleDitto.StItemContainer)((QQCircleDitto.StCircleDittoDataNew)localObject1).itemContainter.get()).subTitle.get();
          try
          {
            int i1 = Integer.parseInt(a(((QQCircleDitto.StItemContainer)((QQCircleDitto.StCircleDittoDataNew)localObject1).itemContainter.get()).busiInfo.get(), "minDisplayItemCount", "3"));
            if (i1 > 0) {
              this.h = i1;
            }
          }
          catch (Exception localException2)
          {
            AEQLog.a("AECircleRecomAutoTemplatePart", localException2);
          }
          localObject1 = ((QQCircleDitto.StItemContainer)((QQCircleDitto.StCircleDittoDataNew)localObject1).itemContainter.get()).items.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)((Iterator)localObject1).next();
            RecomAutoTemplateAdapter.RecomAutoTemplateData localRecomAutoTemplateData = new RecomAutoTemplateAdapter.RecomAutoTemplateData();
            localRecomAutoTemplateData.a = localStItemInfo;
            localRecomAutoTemplateData.f = localStItemInfo.id.get();
            localRecomAutoTemplateData.c = localStItemInfo.name.get();
            localRecomAutoTemplateData.b = a(a(localStItemInfo.busiInfo.get(), "pTuTemplateID", ""));
            localArrayList.add(localRecomAutoTemplateData);
          }
        }
        return localArrayList;
      }
      catch (Exception localException1)
      {
        AEQLog.a("AECircleRecomAutoTemplatePart", localException1);
        return null;
      }
    }
    AEQLog.d("AECircleRecomAutoTemplatePart", "initRecomAutoTemplateData bufferData = null");
    return null;
  }
  
  private boolean r()
  {
    boolean bool2 = "1".equals(QCircleConfigHelper.a("qqcircle", "recommend_video_template_profile_switch", "1"));
    boolean bool1 = true;
    if ((!bool2) || (!LocalMultiProcConfig.getBool("recommend_video_template_profile_switch", true))) {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUserSettingOpened:");
    localStringBuilder.append(bool1);
    AEQLog.b("AECircleRecomAutoTemplatePart", localStringBuilder.toString());
    return bool1;
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    Object localObject2;
    if (paramBundle != null) {
      localObject2 = paramBundle.getString("KEY_LOCAL_PHOTO_CLUSTER");
    }
    for (;;)
    {
      int i2;
      long l2;
      try
      {
        paramBundle = LocalMultiProcConfig.getString("qqcircle_local_recommend_text", AECircleRecomAutoTemplatePart.DefaultValue.b).split(",");
        Object localObject1 = LocalMultiProcConfig.getString("qqcircle_local_video_template_json", AECircleRecomAutoTemplatePart.DefaultValue.a);
        localObject1 = (List)new Gson().fromJson((String)localObject1, new AECircleRecomAutoTemplatePart.8(this).getType());
        ArrayList localArrayList1 = new ArrayList();
        localObject2 = new JSONArray((String)localObject2);
        int i1 = 0;
        if (i1 < ((JSONArray)localObject2).length())
        {
          ArrayList localArrayList2 = new ArrayList();
          Object localObject3 = ((JSONArray)localObject2).optJSONArray(i1);
          i2 = 0;
          l1 = 0L;
          if (i2 < ((JSONArray)localObject3).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject3).optJSONObject(i2);
            LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
            localArrayList2.add(localLocalMediaInfo);
            localLocalMediaInfo._id = localJSONObject.optInt("KEY_LOCAL_PHOTO_CLUSTER_PHOTO_ID");
            localLocalMediaInfo.path = localJSONObject.optString("KEY_LOCAL_PHOTO_CLUSTER_PHOTO_PATH");
            l2 = l1;
            if (l1 != 0L) {
              break label327;
            }
            l2 = localLocalMediaInfo._id;
            break label327;
          }
          localObject3 = new RecomAutoTemplateAdapter.RecomAutoTemplateData();
          localArrayList1.add(localObject3);
          ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject3).d = localArrayList2;
          ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject3).e = MediaStore.Images.Thumbnails.getThumbnail(h().getContentResolver(), l1, 1, null);
          ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject3).f = "";
          ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject3).b = ((MetaMaterial)((List)localObject1).get(i1 % ((List)localObject1).size()));
          ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject3).c = paramBundle[(i1 % paramBundle.length)];
          i1 += 1;
          continue;
        }
        this.m.a(localArrayList1);
        this.k.setVisibility(0);
        return;
      }
      catch (Exception paramBundle)
      {
        AEQLog.a("AECircleRecomAutoTemplatePart", "[updateDataFromLocalPhotoCluster]", paramBundle);
      }
      return;
      label327:
      i2 += 1;
      long l1 = l2;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((RecomAutoTemplateAdapter)localObject).a();
      int i1;
      if (paramBoolean.booleanValue())
      {
        AEReportUtils.a("", 4, "1", "", "", "");
        i1 = 5;
      }
      else
      {
        AEReportUtils.a("", 1, "1", "", "", "");
        i1 = 2;
      }
      if (localObject != null)
      {
        paramBoolean = ((List)localObject).iterator();
        while (paramBoolean.hasNext())
        {
          localObject = (RecomAutoTemplateAdapter.RecomAutoTemplateData)paramBoolean.next();
          AEReportUtils.a("", i1, "1", ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject).f, RecomAutoTemplateAdapter.a(((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject).d), ((RecomAutoTemplateAdapter.RecomAutoTemplateData)localObject).b.id);
        }
      }
    }
  }
  
  public String b()
  {
    return "AECircleRecomAutoTemplatePart";
  }
  
  public void d()
  {
    this.o = Boolean.valueOf(true);
    a(false);
  }
  
  public boolean e()
  {
    ScrollingHeaderLayout localScrollingHeaderLayout = this.i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localScrollingHeaderLayout != null)
    {
      bool1 = bool2;
      if (localScrollingHeaderLayout.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleLoadRecomAutoTemplateDataEvent.class);
    return localArrayList;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.i;
    if ((paramActivity != null) && (paramActivity.getVisibility() == 0) && (!r()))
    {
      this.k.setVisibility(8);
      this.j.setText(h().getText(2064187522));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleLoadRecomAutoTemplateDataEvent)) {
      p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart
 * JD-Core Version:    0.7.0.1
 */