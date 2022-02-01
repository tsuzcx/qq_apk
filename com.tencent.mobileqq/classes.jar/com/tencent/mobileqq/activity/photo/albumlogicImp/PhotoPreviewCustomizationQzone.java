package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhotoPreviewCustomizationQzone
  extends PhotoPreviewCustomizationDefault
  implements SlideShowActionListener
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone";
  int b = 0;
  protected boolean j;
  boolean k;
  public boolean l;
  public boolean m;
  boolean n;
  private HashMap<String, Integer> o;
  
  protected PhotoPreviewCustomizationQzone(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  private int A()
  {
    Object localObject = this.f.selectedPhotoList;
    int i1 = 0;
    if (localObject != null) {
      for (int i = 0;; i = i2)
      {
        i2 = i;
        if (i1 >= this.f.selectedPhotoList.size()) {
          break;
        }
        localObject = (String)this.f.selectedPhotoList.get(i1);
        i2 = i;
        if (this.i.b((String)localObject) == 1) {
          i2 = i + 1;
        }
        i1 += 1;
      }
    }
    int i2 = 0;
    return i2;
  }
  
  public void a()
  {
    super.a();
    if (this.k)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).initPhotoPreviewController(this.c, s().e, this);
      if (s().o != null) {
        s().o.setText("");
      }
      if (s().p != null) {
        s().p.setVisibility(8);
      }
      if (s().m() != -1) {
        b((String)this.d.y.get(s().m()));
      }
      if (this.c.mEnableLiuHai)
      {
        localObject1 = (RelativeLayout)s().c.findViewById(2131447439);
        ((ViewGroup)((RelativeLayout)localObject1).getParent()).removeView((View)localObject1);
        Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
        localObject2 = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(8.0F);
        ((RelativeLayout)this.c.findViewById(2131429579)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
    if ((s().g != null) && (this.j)) {
      s().g.setVisibility(0);
    }
    Object localObject1 = s().p;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setMinWidth(ViewUtils.dpToPx(40.0F));
      ((TextView)localObject1).setGravity(1);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.k)
    {
      Object localObject2 = null;
      RichMediaBrowserInfo localRichMediaBrowserInfo = s().getItem(paramInt);
      Object localObject1 = localObject2;
      if (localRichMediaBrowserInfo != null)
      {
        localObject1 = localObject2;
        if (localRichMediaBrowserInfo.baseData != null) {
          if (localRichMediaBrowserInfo.baseData.getType() == 100)
          {
            localObject1 = ((PreviewPictureData)localRichMediaBrowserInfo.baseData).filePath;
          }
          else
          {
            localObject1 = localObject2;
            if (localRichMediaBrowserInfo.baseData.getType() == 101) {
              localObject1 = ((PreviewVideoData)localRichMediaBrowserInfo.baseData).filePath;
            }
          }
        }
      }
      if (localObject1 != null) {
        s().a((String)localObject1);
      }
      b((String)this.d.y.get(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Intent paramIntent)
  {
    this.d.g = true;
    NewFlowCameraReporter.a("preview create");
    this.d.E = paramIntent.getIntExtra("camera_type", 1);
    this.k = paramIntent.getBooleanExtra("from_qzone_slideshow", false);
    super.a(paramIntent);
    this.o = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.PANORAMA_IMAGES"));
    this.b = paramIntent.getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    this.j = paramIntent.getBooleanExtra("QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW", false);
    this.l = paramIntent.getBooleanExtra("from_qzone", false);
    this.m = paramIntent.getBooleanExtra("fromQzonePhotoGroup", false);
    this.n = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_SHUOSHUO", false);
    if (this.k) {
      SlideShowPhotoListManager.a().b(19);
    }
  }
  
  public void a(View paramView)
  {
    int i = s().m();
    Object localObject;
    if (this.f.selectedIndex.contains(Integer.valueOf(i)))
    {
      if ((this.f.selectedIndex.indexOf(Integer.valueOf(i)) >= 0) && (i != -1))
      {
        localObject = this.o;
        if (localObject != null) {
          ((HashMap)localObject).remove(this.d.y.get(i));
        }
      }
    }
    else
    {
      if (i != -1) {
        localObject = (String)this.d.y.get(i);
      } else {
        localObject = "";
      }
      LocalMediaInfo localLocalMediaInfo = this.i.c((String)localObject);
      if ((this.l) && (this.d.y != null) && (this.i.b((String)localObject) == 1) && (!AlbumUtil.a(this.c, A(), localLocalMediaInfo, this.k)))
      {
        s().m.setChecked(false);
        return;
      }
      if (i != -1)
      {
        localObject = (String)this.d.y.get(i);
        if ((this.l) || (this.k))
        {
          if (this.f.selectedMediaInfoHashMap == null) {
            this.f.selectedMediaInfoHashMap = new HashMap();
          }
          localLocalMediaInfo = this.i.c((String)localObject);
          this.f.selectedMediaInfoHashMap.put(localObject, localLocalMediaInfo);
          if (this.o == null) {
            this.o = new HashMap();
          }
          if (localLocalMediaInfo != null) {
            this.o.put(localObject, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
          }
        }
      }
    }
    super.a(paramView);
    if ((this.k) && (i != -1)) {
      b((String)this.d.y.get(i));
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramInt1 = s().m();
    if (paramInt1 != -1) {
      this.d.m = ((String)this.d.y.get(paramInt1));
    }
    if (this.d.m != null)
    {
      paramView = null;
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      paramBundle = new Intent();
      if (this.f.selectedMediaInfoHashMap != null) {
        paramView = (LocalMediaInfo)this.f.selectedMediaInfoHashMap.get(this.d.m);
      }
      if ((this.j) && (AlbumUtil.getMediaType(paramView) == 1) && (this.l) && (this.d.g))
      {
        new HashMap(1).put("param_localmediainfo", paramView);
        paramBundle = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
        paramBundle.putExtras(this.c.getIntent());
        paramBundle.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        paramBundle.putExtra("DirectBackToQzone", true);
        paramBundle.putExtra("qzone_plugin_activity_name", "com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity");
        paramBundle.putExtra("short_video_refer", getClass().getName());
        paramBundle.putExtra("PhotoConst.EDIT_LOCAL_VIDEO_ENTRY", 1);
        paramBundle.putExtra("file_send_path", this.d.m);
        paramBundle.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramBundle.putExtra("file_send_duration", paramView.mDuration);
        paramBundle.putExtra("file_width", paramView.mediaWidth);
        paramBundle.putExtra("file_height", paramView.mediaHeight);
        paramView = paramBundle;
      }
      else
      {
        paramView = paramBundle;
        if (this.d.g)
        {
          paramView = new HashMap(1);
          paramBundle.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f.selectedPhotoList);
          if ((this.f.selectedMediaInfoHashMap != null) && ((LocalMediaInfo)this.f.selectedMediaInfoHashMap.get(this.d.m) != null)) {
            paramView.put("param_localmediainfo", this.f.selectedMediaInfoHashMap.get(this.d.m));
          }
          if (this.l) {
            paramView = ((IEditPicForQzone)QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.c, this.d.m);
          } else {
            paramView = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, this.d.m, true, true, true, true, true, 3, 99, 4, paramView);
          }
        }
      }
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.d.u);
      this.c.startActivity(paramView);
      this.c.overridePendingTransition(2130772090, 2130772092);
      if (s().g != null) {
        s().g.setClickable(false);
      }
      paramView = this.c.getIntent();
      if ((paramView != null) && (paramView.hasExtra("custom_photopreview_editbtn_reportActionName")))
      {
        paramView = paramView.getStringExtra("custom_photopreview_editbtn_reportActionName");
        if (paramView != null) {
          ReportController.b(null, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
        }
      }
    }
    LpReportInfo_pf00064.allReport(603, 4, 1);
  }
  
  public void a(SlideItemInfo paramSlideItemInfo)
  {
    if (paramSlideItemInfo == null) {
      return;
    }
    b(paramSlideItemInfo);
    int i2 = -1;
    int i = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (i >= this.d.y.size()) {
        break;
      }
      if (((String)this.d.y.get(i)).equals(paramSlideItemInfo.f))
      {
        i1 = i;
        break;
      }
      i += 1;
    }
    if (i1 >= 0)
    {
      if (this.f.selectedIndex.contains(Integer.valueOf(i1)))
      {
        s().m.setChecked(false);
        i = this.f.selectedIndex.indexOf(Integer.valueOf(i1));
        if (i >= 0)
        {
          this.f.selectedPhotoList.remove(this.d.y.get(i1));
          this.f.selectedIndex.remove(i);
          if (this.d.d != null) {
            this.d.d.remove(this.d.y.get(i1));
          }
          if (this.d.b != null) {
            this.d.b.remove(this.d.y.get(i1));
          }
        }
        b();
        b((String)this.d.y.get(i1));
      }
    }
    else
    {
      this.f.selectedPhotoList.remove(paramSlideItemInfo.f);
      b();
      s().a(paramSlideItemInfo.f);
      b(paramSlideItemInfo.f);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.k) && (!this.d.i))
    {
      this.d.y.clear();
      this.d.y.addAll(this.f.selectedPhotoList);
      this.f.selectedIndex.clear();
      i = 0;
      while (i < this.f.selectedPhotoList.size())
      {
        this.f.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
      List localList = this.i.a();
      this.i.notifyImageListChanged(localList, 0);
      this.d.i = true;
    }
    int i1 = this.d.y.indexOf(paramString);
    int i = i1;
    if (i1 < 0) {
      i = 0;
    }
    this.i.browserModel.setSelectedIndex(i);
    s().scrollToCurrentPosition();
  }
  
  public void b()
  {
    super.b();
    Object localObject;
    if (this.k) {
      localObject = this.c.getString(2131897388);
    } else {
      localObject = this.c.getString(2131892542);
    }
    int i = this.b;
    boolean bool2 = true;
    if (i == 1) {
      localObject = this.c.getString(2131892567);
    }
    if (this.f.customSendBtnText != null) {
      localObject = this.f.customSendBtnText;
    }
    boolean bool1;
    if ((s().l != null) && (this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.size() > 0) && (this.b == 1))
    {
      Button localButton = s().l;
      if (this.f.selectedPhotoList.size() >= 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localButton.setEnabled(bool1);
      localButton = s().l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("(");
      localStringBuilder.append(this.f.selectedPhotoList.size());
      localStringBuilder.append(")");
      localButton.setText(localStringBuilder.toString());
    }
    if (this.j)
    {
      if (s().l != null)
      {
        s().l.setText((CharSequence)localObject);
        if (this.k) {
          s().l.setEnabled(false);
        }
      }
      if ((s().g != null) && (this.l) && (this.d.y != null)) {
        s().g.setEnabled(true);
      }
      if (s().j != null)
      {
        s().j.setOnCheckedChangeListener(null);
        localObject = s().j;
        if (((PhotoOtherData)this.g).d == 2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((CheckBox)localObject).setChecked(bool1);
        s().j.setOnCheckedChangeListener(s());
      }
      if ((s().k != null) && (((PhotoOtherData)this.g).d == 2)) {
        s().k.setTextColor(-16734752);
      }
      h();
    }
    if (s().l != null)
    {
      if ((this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.size() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (this.k)
        {
          localObject = s().l;
          if (this.f.selectedPhotoList.size() >= 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((Button)localObject).setEnabled(bool1);
        }
      }
      else if (this.k) {
        s().l.setEnabled(false);
      }
    }
  }
  
  protected void b(int paramInt)
  {
    if (paramInt != -1)
    {
      Object localObject = (String)this.d.y.get(paramInt);
      localObject = this.i.c((String)localObject);
      if (this.k)
      {
        if (!((IQQStoryFlowManager)QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.c, (LocalMediaInfo)localObject))
        {
          s().m.setChecked(false);
          return;
        }
        if (this.f.selectedMediaInfoHashMap == null) {
          this.f.selectedMediaInfoHashMap = new HashMap();
        }
        localObject = (String)this.d.y.get(paramInt);
        LocalMediaInfo localLocalMediaInfo = this.i.c((String)localObject);
        this.f.selectedMediaInfoHashMap.put(localObject, localLocalMediaInfo);
      }
    }
    super.b(paramInt);
    b();
  }
  
  public void b(SlideItemInfo paramSlideItemInfo)
  {
    int i = 0;
    while (i < this.d.y.size())
    {
      if (((String)this.d.y.get(i)).equals(paramSlideItemInfo.f)) {
        break label52;
      }
      i += 1;
    }
    i = -1;
    label52:
    if ((i >= 0) && (i < this.d.y.size()))
    {
      paramSlideItemInfo = this.o;
      if (paramSlideItemInfo != null) {
        paramSlideItemInfo.remove(this.d.y.get(i));
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.k)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.f.selectedPhotoList, this.f.allMediaInfoHashMap);
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).updatePhotoPreviewSelectUI(this.f.selectedPhotoList.indexOf(paramString));
    }
  }
  
  public void c()
  {
    if (this.k) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onPhotoPreviewDestroy();
    }
    super.c();
  }
  
  public void d()
  {
    z();
    Object localObject;
    if (s().m() != -1)
    {
      String str = (String)this.d.y.get(s().m());
      this.f.selectedPhotoList.add(str);
      this.f.selectedIndex.add(Integer.valueOf(s().m()));
      localObject = str;
      if (this.k)
      {
        if (this.f.selectedMediaInfoHashMap == null) {
          this.f.selectedMediaInfoHashMap = new HashMap();
        }
        localObject = this.i.c(str);
        this.f.selectedMediaInfoHashMap.put(str, localObject);
        localObject = str;
      }
    }
    else
    {
      localObject = "";
    }
    s().a((String)localObject);
    b();
    b((String)this.d.y.get(s().m()));
  }
  
  public void i()
  {
    if ((this.d.h) && (this.k)) {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setData(((ISlideShowController)QRoute.api(ISlideShowController.class)).getTemp());
    }
    super.i();
  }
  
  protected void j()
  {
    if (this.m)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.f.selectedIndex);
      this.c.setResult(-1, (Intent)localObject1);
      this.c.finish();
      return;
    }
    Object localObject1 = s().l();
    Object localObject2;
    Object localObject3;
    if ((this.l) && (this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.isEmpty()) && (((ArrayList)localObject1).size() == 1))
    {
      localObject2 = (String)((ArrayList)localObject1).get(0);
      localObject3 = this.i.c((String)localObject2);
      if (localObject3 != null)
      {
        if (this.o == null) {
          this.o = new HashMap();
        }
        this.o.put(localObject2, Integer.valueOf(((LocalMediaInfo)localObject3).panoramaPhotoType));
        if (this.f.selectedMediaInfoHashMap != null)
        {
          this.f.selectedMediaInfoHashMap.clear();
          this.f.selectedMediaInfoHashMap.put(localObject2, localObject3);
        }
      }
      if ((this.i.b((String)localObject2) == 1) && (!AlbumUtil.a(this.c, A(), (LocalMediaInfo)localObject3, this.n)))
      {
        s().l.setClickable(true);
        return;
      }
    }
    if (localObject1 != null)
    {
      StatisticConstants.a(((ArrayList)localObject1).size(), this.d.D);
      StatisticConstants.a(this.c.getIntent(), ((ArrayList)localObject1).size(), ((PhotoOtherData)this.g).d);
    }
    Intent localIntent = this.c.getIntent();
    if (localObject1 != null) {
      NewFlowCameraReporter.a((List)localObject1);
    }
    if ((this.l) || (this.k))
    {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f.selectedMediaInfoHashMap);
      localIntent.putExtra("PhotoConst.PANORAMA_IMAGES", this.o);
    }
    if (1 == this.b) {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    } else {
      localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
    if (this.k) {
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f.selectedMediaInfoHashMap);
    }
    a(localIntent, false, s().l());
    if (localIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false))
    {
      localObject3 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localIntent.getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if ((localObject3 != null) && (localObject1 != null)) {
        ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      }
    }
  }
  
  protected boolean k()
  {
    return this.l ^ true;
  }
  
  public void n()
  {
    super.n();
    if (this.k)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onResume();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).setPhotoPreviewController();
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onItemsSelectChanged(this.f.selectedPhotoList, this.f.allMediaInfoHashMap);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 24747)
    {
      ((ISlideShowController)QRoute.api(ISlideShowController.class)).onClipFinish(paramIntent, this.f.selectedMediaInfoHashMap);
      return;
    }
    if ((this.k) && (paramInt2 == -1))
    {
      this.c.setResult(paramInt2, null);
      this.c.finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View x()
  {
    View localView;
    if (this.k)
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)this.c.getSystemService("layout_inflater");
      localView = null;
      if (localLayoutInflater != null)
      {
        localView = localLayoutInflater.inflate(2131628113, null);
        localView.setPadding(0, 0, 0, AIOUtils.b(12.0F, this.c.getResources()));
        return localView;
      }
    }
    else
    {
      localView = super.x();
    }
    return localView;
  }
  
  public void z()
  {
    int i = s().m();
    if (i != -1)
    {
      String str = (String)this.d.y.get(i);
      if (this.l)
      {
        if (this.f.selectedMediaInfoHashMap == null) {
          this.f.selectedMediaInfoHashMap = new HashMap();
        }
        LocalMediaInfo localLocalMediaInfo = this.i.c(str);
        this.f.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
        if (this.o == null) {
          this.o = new HashMap();
        }
        if (localLocalMediaInfo != null) {
          this.o.put(str, Integer.valueOf(localLocalMediaInfo.panoramaPhotoType));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone
 * JD-Core Version:    0.7.0.1
 */