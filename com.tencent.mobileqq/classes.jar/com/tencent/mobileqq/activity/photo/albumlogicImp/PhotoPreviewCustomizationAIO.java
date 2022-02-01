package com.tencent.mobileqq.activity.photo.albumlogicImp;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoConst.Menu;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoSelectedThumbAdapter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.recyclerview.DragView;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.SystemBarTintManager;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class PhotoPreviewCustomizationAIO
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO";
  public int a;
  private SendByFile a;
  public boolean a;
  boolean b;
  boolean c;
  protected boolean d = false;
  protected boolean e = false;
  public boolean f = false;
  
  PhotoPreviewCustomizationAIO(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
    this.jdField_a_of_type_Int = 1052;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void d()
  {
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)
    {
      ((Intent)localObject4).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
    int k = 0;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("custom_photopreview_sendbtn_report", false)))
    {
      localObject3 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportActionName");
      localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
      }
      if (localObject1 == null) {
        localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportReverse2");
      }
      if (localObject1 == null) {
        localObject1 = "";
      }
      if ((localObject3 != null) && (localObject1 != null)) {
        ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
      }
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Int > 0))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f.values().iterator();
        j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject2).equals(localObject4))) {
            j += 1;
          }
        }
      }
      localObject1 = new StringBuilder();
      int j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
      }
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ReportController.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    }
  }
  
  private void h(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = 2;
    } else {
      j = 1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", j, 0, "", "", "", "");
    Object localObject2;
    Object localObject1;
    if (i != 0)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Long >= 700L)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
        if (this.d) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131694855, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
        } else {
          localObject1 = a().a();
        }
        QQToast.a((Context)localObject2, (CharSequence)localObject1, 1000).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Long = l;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if ((paramInt != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject1);
      localObject1 = PresendPicMgr.a(null);
      if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt)) != 1)) {
        ((PresendPicMgr)localObject1).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Int);
      }
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PhotoSendParams)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
      a().a((String)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      if (localObject2 != null)
      {
        NewPhotoPreviewActivity localNewPhotoPreviewActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
        boolean bool;
        if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((SendByFile)localObject2).a(localNewPhotoPreviewActivity, (String)localObject1, bool, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, true);
      }
    }
    b();
  }
  
  private void i(int paramInt)
  {
    a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt), 1014);
        }
      }
    }
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = false;
    }
  }
  
  public Intent a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      return localIntent;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    RichMediaBrowserInfo localRichMediaBrowserInfo = a().getItem(a().a());
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localRichMediaBrowserInfo != null)
    {
      bool1 = bool2;
      if (localRichMediaBrowserInfo.baseData != null) {
        if (localRichMediaBrowserInfo.baseData.getType() == 101) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    b(bool1);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.size() != 0)) {
      a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.e)
    {
      super.d(8);
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
      a().e.setVisibility(8);
    }
    if (d()) {
      b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent());
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool;
    if (a().getItem(paramInt).baseData.getType() == 101) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_ORIGIN", false) ^ true;
      if (!bool) {
        return;
      }
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (str == null) {
        return;
      }
      ThreadManager.excute(new PhotoPreviewCustomizationAIO.6(this, str), 64, null, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onActivityResultForMultiEdit hasEdit:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", picPath:");
        ((StringBuilder)localObject).append(str);
        QLog.i("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramIntent.getStringExtra("key_multi_edit_source_path");
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject);
      if (paramInt1 >= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f.containsValue(localObject)) {
          paramIntent = ReplacePhotoDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f, (String)localObject);
        } else {
          paramIntent = (Intent)localObject;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f.put(paramIntent, str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, str);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1 + 1);
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.indexOf(localObject);
        if (paramInt2 >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramInt2, str);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(paramInt2 + 1);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.selectedPhotoAdapter.notifyDataSetChanged();
        paramIntent = new RichMediaBrowserInfo();
        PreviewPictureData localPreviewPictureData = new PreviewPictureData();
        localPreviewPictureData.filePath = str;
        paramIntent.baseData = localPreviewPictureData;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a.updateItem(paramIntent, paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a.setSelectedIndex(paramInt1);
        a().notifyDataSetChanged();
        a().scrollToCurrentPosition();
        paramIntent = PresendPicMgr.a();
        if (paramIntent != null)
        {
          paramIntent.b((String)localObject, 1003);
          paramIntent.a(str, this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean = true;
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    this.d = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.e = paramIntent.getBooleanExtra("input_full_screen_click", false);
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.f = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    Object localObject;
    if (this.f)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = PresendPicMgr.a(null);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        ((PresendPicMgr)localObject).a(1003);
      }
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, true);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
    {
      localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
        this.jdField_a_of_type_Int = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.jdField_a_of_type_Int);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131694885);
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131694839);
    }
    StatisticConstants.c();
    if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new SendByFile().a(((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).b);
    boolean bool1 = bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile = paramIntent.a(bool1);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
    boolean bool;
    if (localObject1 != null)
    {
      if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayList = ((SendByFile)localObject1).a(paramArrayList, bool, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
      ((ArrayList)localPair.first).addAll((Collection)paramArrayList.first);
      ((ArrayList)localPair.second).addAll((Collection)paramArrayList.second);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)localPair.second);
    }
    else
    {
      ((ArrayList)localPair.first).addAll(paramArrayList);
    }
    int k;
    try
    {
      k = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo)paramIntent.getParcelableExtra("session_info"));
    }
    catch (Exception paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAlbum", 2, "submit", paramArrayList);
      }
      k = -1;
    }
    paramArrayList = new HashMap();
    int n = 0;
    int j = 0;
    int i = 0;
    int m = 0;
    while (n < ((ArrayList)localPair.first).size())
    {
      localObject1 = (String)((ArrayList)localPair.first).get(n);
      if (!ImageManager.isNetworkUrl((String)localObject1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject1) == 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject1);
          localObject2 = new SendVideoInfo();
          i += 1;
          ((SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
          ((SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
          paramArrayList.put(Integer.valueOf(m), localObject2);
        }
        else
        {
          j += 1;
        }
        m += 1;
      }
      n += 1;
    }
    localObject1 = String.valueOf(j);
    Object localObject2 = String.valueOf(i);
    try
    {
      paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
      if (paramArrayList.isEmpty()) {
        break label411;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    catch (Exception paramArrayList)
    {
      label395:
      break label395;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "put extra Exception");
    }
    label411:
    i = 0;
    if ((SVBusiUtil.b != 0L) && (System.currentTimeMillis() - SVBusiUtil.b < 300000L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("upload video isConfirmed=");
      paramArrayList.append(bool);
      paramArrayList.append(" allowUploadInXGTime=");
      paramArrayList.append(SVBusiUtil.b);
      QLog.d("QQAlbum", 2, paramArrayList.toString());
    }
    if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (!bool) && (i != 0) && (b()))
    {
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131718735);
      paramIntent = new PhotoPreviewCustomizationAIO.2(this, paramBoolean, paramIntent, localPair, k, (String)localObject1, (String)localObject2);
      if (FreeWifiHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, 4, new PhotoPreviewCustomizationAIO.3(this, paramIntent))) {
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, 232, null, paramArrayList, new PhotoPreviewCustomizationAIO.4(this, paramIntent), new PhotoPreviewCustomizationAIO.5(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAlbum", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
    else
    {
      if (paramBoolean)
      {
        ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      }
      else
      {
        PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramIntent, (ArrayList)localPair.first, ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean);
      }
      ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", k, 0, (String)localObject1, (String)localObject2, "", "");
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources();
    int i = a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(i))) {
      i(i);
    } else {
      h(i);
    }
    LpReportInfo_pf00064.allReport(603, 2);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.a(paramView, 10000, paramBundle, 2, null);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a().jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      a().jdField_b_of_type_AndroidWidgetTextView.setTextColor(2147483647);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      if (paramCompoundButton != null) {
        if (!this.jdField_c_of_type_Boolean) {
          paramCompoundButton.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap);
        } else {
          this.jdField_c_of_type_Boolean = false;
        }
      }
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 2;
      a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
      b();
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
      if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
      {
        paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
        if (paramCompoundButton != null) {
          ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      a().jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int = 0;
      f();
    }
  }
  
  protected void a(TextView paramTextView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!NetworkUtils.isNetworkUrl((String)localObject2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject2) == 1)) {
        paramTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.e));
      }
    }
    int i = QQAlbumUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap, true, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap);
    if (i == 0)
    {
      paramTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.e));
      return;
    }
    localObject1 = PhotoUtils.getRawPhotoSize(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, i);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0) && (!((String)localObject1).equals("0")))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.e));
      ((StringBuilder)localObject2).append("(共");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(PhotoConst.Menu.e);
    }
    paramTextView.setText((CharSequence)localObject1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = true;
      a().jdField_b_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean ^ true);
      a().jdField_c_of_type_AndroidWidgetTextView.setTextColor(2147483647);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty()) && (a().a() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        a().jdField_c_of_type_AndroidViewView.performClick();
        b();
      }
      if ((a().a() != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.size() > a().a()))
      {
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a())) != 1) {
          i = 1;
        } else {
          i = 0;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup == null) && (i != 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.j = false;
          BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).edit().putBoolean("showFlashPic", false).commit();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup = new BubblePopupWindow(-2, -2);
          TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
          i = AIOUtils.b(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
          localTextView.setPadding(i, 0, i, 0);
          localTextView.setTextColor(-1);
          localTextView.setText("选中的图片每人只能查看一次");
          localTextView.setTextSize(14.0F);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.setContentView(localTextView);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.setFocusable(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.showAsDropDown(a().jdField_b_of_type_AndroidWidgetTextView);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X8006997", "0X8006997", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X8006998", "0X8006998", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8006999", "0X8006999", 0, 0, "", "", "", "");
      }
    }
    else
    {
      a().jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.popup.dismiss();
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.isEmpty());
  }
  
  protected void b(int paramInt)
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Long >= 700L)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, a().a(), 1000).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Long = l;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) {
          ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
        }
      }
      a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      return;
    }
    if (paramInt != -1)
    {
      Object localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject2);
      if ((((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2) && (c())) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (BaseImageUtil.b((String)localObject2)) && (FileUtils.getFileSizes((String)localObject2) > 3145728L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, "图片文件过大", 0).a();
        a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return;
      }
      if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt)) != 1)) {
        ((PresendPicMgr)localObject1).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_Int);
      }
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PhotoSendParams)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap != null)
      {
        localObject2 = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
      a().a((String)localObject1);
    }
    b();
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = (Rect)paramIntent.getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i = SystemBarTintManager.getNavigationBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
    paramIntent.top -= i;
    paramIntent.bottom -= i;
    a().mDragView.setOriginRect(paramIntent);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 3000))
      {
        f(8);
        return;
      }
      g(8);
      return;
    }
    f(0);
  }
  
  protected void c(int paramInt)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    a().jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(paramInt), 1014);
        }
      }
    }
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = false;
    }
  }
  
  protected boolean c()
  {
    Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.get(a().a());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject) == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131719099), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDimensionPixelSize(2131299168));
        AlbumUtil.c();
      }
      return false;
    }
    return super.c();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getBooleanExtra("PHOTO_PREVIEW_NEED_DRAG_KEY", false);
  }
  
  void f(int paramInt)
  {
    a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
    a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean)
      {
        a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(8);
        a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
        a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaUtilHashMap.size() == 0))
      {
        a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        a().jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(a());
        a().jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new PhotoPreviewCustomizationAIO.1(this));
        a().jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("闪照");
        a().jdField_b_of_type_AndroidWidgetTextView.setContentDescription("闪照");
      }
    }
    else if (a().jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 0)
    {
      a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
      a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  void g(int paramInt)
  {
    a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    a().jdField_b_of_type_AndroidWidgetCheckBox.setVisibility(0);
    a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    if (a().jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != paramInt)
    {
      a().jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(paramInt);
      a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  protected void h()
  {
    d();
    Object localObject1;
    Object localObject2;
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_JavaLangString))
    {
      localObject1 = a().a();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1))
      {
        localObject1 = (String)((ArrayList)localObject1).get(0);
        if ((localObject1 != null) && (((String)localObject1).startsWith("http")))
        {
          localObject2 = (PhotoSendParams)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
          if (localObject2 != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.put(localObject1, localObject2);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") != null) {
          localObject1 = (Intent)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
        } else {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
        }
        ((Intent)localObject1).setExtrasClassLoader(PeakConstants.class.getClassLoader());
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        a((Intent)localObject1, true, a().a());
      }
    }
    else if (this.d)
    {
      localObject1 = a(a().a());
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, (Intent)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) && ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_JavaLangString)))) {
        a().jdField_a_of_type_AndroidWidgetTextView.performClick();
      }
      localObject1 = a().a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
      StatisticConstants.a(((ArrayList)localObject1).size(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_d_of_type_Int);
      StatisticConstants.a((Intent)localObject2, ((ArrayList)localObject1).size(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int);
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).jdField_a_of_type_Int == 2)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) && (((ArrayList)localObject1).size() == 1) && (FileUtils.getFileSizes((String)((ArrayList)localObject1).get(0)) > ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131694867), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDimensionPixelSize(2131299168));
          a().jdField_a_of_type_AndroidWidgetButton.setClickable(true);
          return;
        }
        if (localPresendPicMgr != null)
        {
          localPresendPicMgr.a(1010);
          localPresendPicMgr.a();
        }
        ReportController.b(null, "CliOper", "", "", "0X800515C", "0X800515C", 0, 0, "", "", "", "");
      }
      else if ((localPresendPicMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) && (!((Intent)localObject2).getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData)))
      {
        localPresendPicMgr.a((Intent)localObject2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean) {
        a().jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      NewFlowCameraReporter.a((List)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l)
      {
        ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        ((Intent)localObject2).putExtra("session_info", (SessionInfo)((Intent)localObject2).getParcelableExtra("session_info"));
      }
      a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.containNetImage(), a().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO
 * JD-Core Version:    0.7.0.1
 */