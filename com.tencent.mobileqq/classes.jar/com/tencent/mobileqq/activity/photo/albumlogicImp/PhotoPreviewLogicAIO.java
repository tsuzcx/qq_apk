package com.tencent.mobileqq.activity.photo.albumlogicImp;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PhotoPreviewLogicAIO
  extends PhotoPreviewLogicDefault
{
  private SendByFile a;
  public boolean a;
  boolean b;
  boolean c;
  protected boolean d = false;
  protected boolean e = false;
  
  PhotoPreviewLogicAIO(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void e()
  {
    Object localObject4 = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    Object localObject3;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)
    {
      ((Intent)localObject4).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ((localObject4 != null) && (((Intent)localObject4).getBooleanExtra("custom_photopreview_sendbtn_report", false)))
      {
        localObject3 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportActionName");
        localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((Intent)localObject4).getStringExtra("custom_photopreview_sendbtn_reportReverse2");
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if ((localObject3 != null) && (localObject1 != null)) {
          ReportController.b(null, "CliOper", "", "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject1, "", "", "");
        }
      }
      if ((!needShowMultiPhoto()) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.e <= 0)) {
        break label532;
      }
      localObject1 = this.mPhotoCommonData.selectedPhotoList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label451;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject2).equals(localObject4)))
          {
            i += 1;
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 3000)
            {
              ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
              ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int != 1) {
              break;
            }
            ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
            ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
            break;
          }
        }
      }
    }
    label451:
    Object localObject1 = new StringBuilder();
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int j = this.mPhotoCommonData.selectedPhotoList.size();; j = 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A070", "0X800A070", 0, 0, j + "", i + "", "", "");
      label532:
      return;
    }
  }
  
  private void f(int paramInt)
  {
    int i;
    int j;
    label28:
    long l;
    Object localObject2;
    if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum)
    {
      i = 1;
      if (i == 0) {
        break label209;
      }
      j = 2;
      ReportController.b(null, "dc00898", "", "", "0X800AB6E", "0X800AB6E", j, 0, "", "", "", "");
      if (i == 0) {
        break label229;
      }
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.lastTimeShowToast >= 700L)
      {
        localObject2 = this.mActivity;
        if (!this.d) {
          break label214;
        }
      }
    }
    label209:
    label214:
    for (Object localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694868, new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) });; localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getExceedMaxSelectNumStr())
    {
      QQToast.a((Context)localObject2, (CharSequence)localObject1, 1000).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.titleBarHeight);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.lastTimeShowToast = l;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l) {
        ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      }
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
      return;
      i = 0;
      break;
      j = 1;
      break label28;
    }
    label229:
    AbstractPhotoPreviewActivity localAbstractPhotoPreviewActivity;
    if ((paramInt != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.size() > paramInt))
    {
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt);
      ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
      localObject1 = PresendPicMgr.a(null);
      if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt)) != 1)) {
        ((PresendPicMgr)localObject1).a((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f);
      }
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt);
      this.mPhotoCommonData.selectedPhotoList.add(localObject1);
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d != null) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d.put(localObject1, localObject2);
        }
      }
      this.mPhotoCommonData.selectedIndex.add(Integer.valueOf(paramInt));
      ((NewPhotoPreviewActivity)this.mActivity).setCheckedNumber((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
        localAbstractPhotoPreviewActivity = this.mActivity;
        if (this.mPhotoCommonData.currentQualityType != 2) {
          break label587;
        }
      }
    }
    label587:
    for (boolean bool = true;; bool = false)
    {
      ((SendByFile)localObject2).a(localAbstractPhotoPreviewActivity, (String)localObject1, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      updateButton();
      return;
    }
  }
  
  private void g(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setChecked(false);
    int i = this.mPhotoCommonData.selectedIndex.indexOf(Integer.valueOf(paramInt));
    if (i >= 0)
    {
      this.mPhotoCommonData.selectedIndex.remove(i);
      if (paramInt != -1)
      {
        this.mPhotoCommonData.selectedPhotoList.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt));
        }
        PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(paramInt), 1014);
        }
      }
    }
    updateButton();
    if ((this.mPhotoCommonData.selectedIndex.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.i)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.k = false;
    }
  }
  
  public Intent a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PhotoConst.editPathMap", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.editPathMap);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    return localIntent;
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    localPair = new Pair(new ArrayList(), new ArrayList());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      if (this.mPhotoCommonData.currentQualityType == 2) {
        bool = true;
      }
    }
    for (;;)
    {
      paramArrayList = ((SendByFile)localObject1).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      ((ArrayList)localPair.first).addAll((Collection)paramArrayList.first);
      ((ArrayList)localPair.second).addAll((Collection)paramArrayList.second);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)localPair.second);
      i2 = 0;
      i = -1;
      try
      {
        m = PhotoUtils.getTypeforReportSpcialDiscuss((SessionInfo)paramIntent.getParcelableExtra("session_info"));
        paramArrayList = new HashMap();
        j = 0;
        i = 0;
        int n = 0;
        k = 0;
        for (;;)
        {
          if (n < ((ArrayList)localPair.first).size())
          {
            localObject1 = (String)((ArrayList)localPair.first).get(n);
            if (ImageManager.isNetworkUrl((String)localObject1))
            {
              i1 = k;
              k = i;
              i = i1;
              n += 1;
              i1 = k;
              k = i;
              i = i1;
              continue;
              bool = false;
              break;
              ((ArrayList)localPair.first).addAll(paramArrayList);
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        int j;
        int k;
        int i1;
        for (;;)
        {
          m = i;
          if (QLog.isColorLevel())
          {
            QLog.e("PhotoPreviewActivity", 2, "submit", paramArrayList);
            m = i;
          }
        }
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject1);
          localObject2 = new SendVideoActivity.SendVideoInfo();
          i += 1;
          ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
          ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
          paramArrayList.put(Integer.valueOf(k), localObject2);
        }
        for (;;)
        {
          i1 = k + 1;
          k = i;
          i = i1;
          break;
          j += 1;
        }
        localObject1 = String.valueOf(j);
        localObject2 = String.valueOf(i);
      }
    }
    try
    {
      paramIntent.setExtrasClassLoader(SessionInfo.class.getClassLoader());
      if (paramArrayList.isEmpty()) {
        break label793;
      }
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
      i = 1;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        i = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoPreviewActivity", 2, "put extra Exception");
          i = i2;
          continue;
          bool = false;
          continue;
          if (paramBoolean)
          {
            PhotoUtils.sendPhoto(this.mActivity, paramIntent, (ArrayList)localPair.first, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.currentQualityType, true);
            ((NewPhotoPreviewActivity)this.mActivity).setResult(-1);
            ((NewPhotoPreviewActivity)this.mActivity).finish();
          }
          for (;;)
          {
            ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", m, 0, (String)localObject1, (String)localObject2, "", "");
            return;
            PhotoUtils.sendPhoto(this.mActivity, paramIntent, (ArrayList)localPair.first, this.mPhotoCommonData.currentQualityType, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Boolean);
          }
          i = 0;
        }
      }
    }
    if ((ShortVideoBusiManager.b != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.b < 300000L))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + ShortVideoBusiManager.b);
      }
      if ((!NetworkUtil.b(BaseApplicationImpl.getContext())) || (bool) || (i == 0) || (!a())) {
        break label676;
      }
      paramArrayList = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719019);
      paramIntent = new PhotoPreviewLogicAIO.2(this, paramBoolean, paramIntent, localPair, m, (String)localObject1, (String)localObject2);
      if (FreeWifiHelper.a(this.mActivity, 4, new PhotoPreviewLogicAIO.3(this, paramIntent))) {
        DialogUtil.a(this.mActivity, 232, null, paramArrayList, new PhotoPreviewLogicAIO.4(this, paramIntent), new PhotoPreviewLogicAIO.5(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoPreviewActivity", 2, "show shortvideo_mobile_send_confirm dialog");
      }
    }
  }
  
  public void a(TextView paramTextView)
  {
    Object localObject = this.mPhotoCommonData.selectedPhotoList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!NetworkUtils.isNetworkUrl(str)) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) == 1)) {
        paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
      }
    }
    int i = AlbumUtil.a(this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.allMediaInfoHashMap, true, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap, this.mPhotoCommonData.selectedMediaInfoHashMap);
    if (i == 0)
    {
      paramTextView.setText(((NewPhotoPreviewActivity)this.mActivity).getString(2131694882));
      return;
    }
    localObject = PhotoUtils.getRawPhotoSize(this.mActivity, i);
    if ((this.mPhotoCommonData.selectedPhotoList.size() == 0) || (((String)localObject).equals("0"))) {}
    for (localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131694882);; localObject = ((NewPhotoPreviewActivity)this.mActivity).getString(2131694882) + "(共" + (String)localObject + ")")
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    Object localObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion());
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject) == 1)
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
      if ((localObject != null) && (((LocalMediaInfo)localObject).fileSize > 104345600L))
      {
        QQToast.a(this.mActivity, ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131719381), 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
        AlbumUtil.c();
      }
      return false;
    }
    return super.b();
  }
  
  public void d()
  {
    e();
    Object localObject;
    if ("FROM_QZONE_PHOTO_LIST".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.from))
    {
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
      if ((localObject != null) && (((ArrayList)localObject).size() == 1))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        if ((localObject != null) && (((String)localObject).startsWith("http")))
        {
          PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (localPhotoSendParams != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.put(localObject, localPhotoSendParams);
          }
        }
      }
      if (this.mPhotoCommonData.selectedPhotoList.size() != 0)
      {
        if (((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent") == null) {
          break label215;
        }
        localObject = (Intent)((NewPhotoPreviewActivity)this.mActivity).getIntent().getParcelableExtra("PhotoConst.sendToAIOIntent");
        ((Intent)localObject).setExtrasClassLoader(PeakConstants.class.getClassLoader());
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        a((Intent)localObject, true, ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
      }
    }
    label215:
    do
    {
      return;
      localObject = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
      break;
      if (!this.d) {
        break label278;
      }
      localObject = a(((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList());
    } while (localObject == null);
    ((NewPhotoPreviewActivity)this.mActivity).setResult(-1, (Intent)localObject);
    ((NewPhotoPreviewActivity)this.mActivity).finish();
    return;
    label278:
    super.d();
  }
  
  void d(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(paramInt);
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_Boolean)
      {
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
        ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean) {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.h) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d.size() == 0))
      {
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setOnCheckedChangeListener(this.mActivity);
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setOnClickListener(new PhotoPreviewLogicAIO.1(this));
        ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setContentDescription("闪照");
        ((NewPhotoPreviewActivity)this.mActivity).flashTv.setContentDescription("闪照");
      }
    }
    while (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() != 0) {
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
  }
  
  void e(int paramInt)
  {
    ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(paramInt);
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
    if (((NewPhotoPreviewActivity)this.mActivity).flashPicCb.getVisibility() == 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setVisibility(paramInt);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setVisibility(paramInt);
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    this.d = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.e = paramIntent.getBooleanExtra("input_full_screen_click", false);
    super.initData(paramIntent);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.isSingleMode)
    {
      Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
      if (localObject != null)
      {
        if (PresendPicMgr.a(null) != null) {
          PresendPicMgr.a(null).b();
        }
        localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f = 1037;
        paramIntent = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
        if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramIntent) != 1) {
          ((PresendPicMgr)localObject).a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694896);
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getResources().getString(2131694852);
    }
    StatisticConstants.c();
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new SendByFile().a(((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_Int).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.l)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile = paramIntent.a(bool);
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_b_of_type_JavaUtilHashMap.size() != 0)) {
      ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(8);
    }
    if (this.e)
    {
      super.c(8);
      ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    }
  }
  
  public boolean needShowMultiPhoto()
  {
    return (this.mPhotoCommonData.selectedPhotoList != null) && (!this.mPhotoCommonData.selectedPhotoList.isEmpty());
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo(((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt));
    if ((localLocalMediaInfo != null) && (((NewPhotoPreviewActivity)this.mActivity).getMediaType(localLocalMediaInfo.path) == 1)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_Int == 3000)) {
        e(8);
      }
    }
    for (;;)
    {
      super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      d(8);
      continue;
      d(0);
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    paramBundle.putBoolean("key_multi_edit_pic", true);
    paramBundle.putBoolean("key_enable_edit_title_bar", true);
    super.onMagicStickClick(paramView, 10000, paramBundle, 2, null);
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((NewPhotoPreviewActivity)this.mActivity).flashPicCb.setChecked(false);
      ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(2147483647);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label168;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
      }
      for (;;)
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setChecked(true);
        updateButton();
        paramCompoundButton = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
        if ((paramCompoundButton != null) && (paramCompoundButton.hasExtra("custom_photopreview_rawcheckbox_reportActionName")))
        {
          paramCompoundButton = paramCompoundButton.getStringExtra("custom_photopreview_rawcheckbox_reportActionName");
          if (paramCompoundButton != null) {
            ReportController.b(null, "CliOper", "", "", paramCompoundButton, paramCompoundButton, 0, 0, "", "", "", "");
          }
        }
        return;
        label168:
        this.jdField_c_of_type_Boolean = false;
      }
    }
    ((NewPhotoPreviewActivity)this.mActivity).flashTv.setTextColor(-1);
    this.mPhotoCommonData.currentQualityType = 0;
    c();
  }
  
  public void onSelectClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.mActivity).getResources();
    int i = ((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion();
    if (this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(i))) {
      g(i);
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 2);
      return;
      f(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAIO
 * JD-Core Version:    0.7.0.1
 */