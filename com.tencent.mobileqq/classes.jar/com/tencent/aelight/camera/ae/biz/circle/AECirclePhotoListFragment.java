package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleClearAllSelectEvent;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECirclePreviewPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart;
import com.tencent.aelight.camera.ae.biz.circle.part.AECircleTitleChipPart;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePartFragment;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECirclePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AECirclePhotoListFragment
  extends AECircleBasePartFragment
  implements SimpleEventReceiver
{
  public AECirclePhotoListLogic a;
  public PhotoListBaseData b;
  AECirclePhotoListPart c;
  AECircleAlbumListPart d;
  AECirclePreviewPart e;
  AECircleSelectPanelPart f;
  AECircleTitleChipPart g;
  AECircleRecomAutoTemplatePart h;
  public String i = "";
  private Boolean k = Boolean.valueOf(false);
  private BroadcastReceiver l;
  private BroadcastReceiver m = new AECirclePhotoListFragment.1(this);
  
  private void a(Intent paramIntent)
  {
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("key_qcircle_photo_path_image_edit");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramIntent.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.mMimeType = "image";
        localHashMap.put(str, localLocalMediaInfo);
      }
      if (this.a.c.selectedPhotoList.size() == 0)
      {
        this.a.c.selectedPhotoList.addAll(paramIntent);
        this.a.g().initialHasPickedNum = 0;
      }
      if (this.a.c.selectedMediaInfoHashMap == null) {
        this.a.c.selectedMediaInfoHashMap = new HashMap();
      }
      if (this.a.c.selectedMediaInfoHashMap.size() == 0) {
        this.a.c.selectedMediaInfoHashMap.putAll(localHashMap);
      }
    }
  }
  
  private void i()
  {
    this.a = new AECirclePhotoListLogic(this);
    this.b = this.a.d;
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null)
    {
      QLog.d("SelectPhotoTrace", 1, "AECirclePhotoListFragment initLogic() intent is null!");
      return;
    }
    this.a.a(localIntent, getActivity());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AECirclePhotoListFragment initLogic(),extra is:");
      localStringBuilder.append(localIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
  }
  
  private void j()
  {
    Object localObject = new IntentFilter("action_mid_page_multi_replace_to_photo_list");
    getActivity().registerReceiver(this.m, (IntentFilter)localObject);
    localObject = this.a;
    if ((localObject != null) && (((AECirclePhotoListLogic)localObject).c != null) && (this.a.c.selectedPhotoList.size() > 0)) {
      this.i = "midPageMultiReplace";
    }
  }
  
  private Boolean k()
  {
    Object localObject = this.a;
    Boolean localBoolean = Boolean.valueOf(true);
    if ((localObject != null) && (((AECirclePhotoListLogic)localObject).e != null) && (this.a.e.b != -1)) {
      return localBoolean;
    }
    localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).getExtras() != null) && (getActivity().getIntent().getExtras().getBoolean("key_qcircle_is_from_pic_preview_part", false))) {
      return localBoolean;
    }
    return Boolean.valueOf(false);
  }
  
  private void l()
  {
    if (this.j == null)
    {
      QLog.e("AECirclePhotoListFragment", 1, "reportDaTongRegister  view == null");
      return;
    }
    VideoReport.setPageId(this.j, "pg_xsj_choose_media_page");
    VideoReport.setPageParams(this.j, new QCircleDTParamBuilder().buildPageParams("AECirclePhotoListFragment"));
    QLog.i("AECirclePhotoListFragment", 1, "reportDaTongRegister  subPage: AECirclePhotoListFragment");
  }
  
  public void a()
  {
    Intent localIntent = new Intent("action_mid_page_multi_replace_to_photo_list");
    Object localObject = this.a;
    if ((localObject != null) && (((AECirclePhotoListLogic)localObject).c != null) && (this.a.c.selectedPhotoList.size() > 0))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("key_photo_path_between_fragment", this.a.c.selectedPhotoList);
      ((Bundle)localObject).putSerializable("key_qcircle_mid_page_photo_path", this.a.c.selectedMediaInfoHashMap);
      localIntent.putExtras((Bundle)localObject);
      this.i = "midPageMultiReplace";
    }
    getActivity().sendBroadcast(localIntent);
  }
  
  protected List<AECircleBasePart> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.d = new AECircleAlbumListPart(this.a);
    this.c = new AECirclePhotoListPart(this.a);
    this.e = new AECirclePreviewPart(this.a);
    this.f = new AECircleSelectPanelPart(this.a);
    if (this.i.equals("midPageMultiReplace")) {
      this.f.e();
    }
    this.g = new AECircleTitleChipPart(this.a);
    this.g.a(false);
    Intent localIntent = getActivity().getIntent();
    this.h = new AECircleRecomAutoTemplatePart(this.a, localIntent.getExtras());
    localArrayList.add(this.d);
    localArrayList.add(this.c);
    localArrayList.add(this.e);
    localArrayList.add(this.f);
    localArrayList.add(this.g);
    localArrayList.add(this.h);
    return localArrayList;
  }
  
  protected int c()
  {
    return 2064056361;
  }
  
  public void d()
  {
    if (e().booleanValue())
    {
      AEReportUtils.a("", 16, "2");
      return;
    }
    AEReportUtils.a("", 15, "1");
  }
  
  public Boolean e()
  {
    if ((!getActivity().getIntent().getBooleanExtra("key_qcircle_from_mid_page", false)) && (!this.k.booleanValue())) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public boolean f()
  {
    return (h() != null) && (h().a());
  }
  
  public boolean g()
  {
    return (h() == null) || (h().b());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleClearAllSelectEvent.class);
    return localArrayList;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      return;
    }
    a(paramIntent);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    i();
    j();
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("AECirclePhotoListFragment,hashCode is:");
      paramBundle.append(System.identityHashCode(this));
      QLog.d("SelectPhotoTrace", 2, paramBundle.toString());
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.j = paramLayoutInflater.inflate(c(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AECirclePhotoListFragment", 1, localThrowable, new Object[0]);
    }
    Object localObject = this.a;
    if ((localObject != null) && (((AECirclePhotoListLogic)localObject).e != null) && (k().booleanValue()))
    {
      localObject = this.h;
      if (localObject != null) {
        ((AECircleRecomAutoTemplatePart)localObject).d();
      }
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    ViewCompat.setOnApplyWindowInsetsListener(this.j, new AECirclePhotoListFragment.2(this));
    if (this.j != null) {
      this.j.post(new AECirclePhotoListFragment.3(this));
    }
    l();
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("onCreateView cost:");
    paramLayoutInflater.append(System.currentTimeMillis() - l1);
    QLog.d("[Performance2]AECirclePhotoListFragment", 1, paramLayoutInflater.toString());
    return this.j;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.j();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    try
    {
      getActivity().unregisterReceiver(this.m);
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a("AECirclePhotoListFragment", "unregister mPublishMoodFinishReceiver", localException);
    }
  }
  
  public void onPause()
  {
    AEQLog.b("AECirclePhotoListFragment", "onPause---");
    super.onPause();
    try
    {
      getActivity().unregisterReceiver(this.l);
      return;
    }
    catch (Exception localException)
    {
      AEQLog.a("AECirclePhotoListFragment", "unregister mLocalPhotoClusterFromQCircleReceiver", localException);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleClearAllSelectEvent))
    {
      paramSimpleBaseEvent = this.a;
      if (paramSimpleBaseEvent != null)
      {
        paramSimpleBaseEvent.l();
        paramSimpleBaseEvent = this.c;
        if (paramSimpleBaseEvent != null) {
          paramSimpleBaseEvent.c();
        }
        SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
      }
    }
  }
  
  public void onResume()
  {
    AEQLog.b("AECirclePhotoListFragment", "onResume---");
    super.onResume();
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    AECircleRecomAutoTemplatePart localAECircleRecomAutoTemplatePart = this.h;
    if ((localAECircleRecomAutoTemplatePart != null) && (localAECircleRecomAutoTemplatePart.e())) {
      this.h.a(Boolean.valueOf(false));
    }
    if (this.l == null) {
      this.l = new AECirclePhotoListFragment.4(this);
    }
    getActivity().registerReceiver(this.l, new IntentFilter("action_local_photo_cluster"));
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */