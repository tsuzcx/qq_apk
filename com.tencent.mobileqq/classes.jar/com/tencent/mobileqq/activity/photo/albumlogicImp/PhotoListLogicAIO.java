package com.tencent.mobileqq.activity.photo.albumlogicImp;

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
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PhotoListLogicAIO
  extends PhotoListLogicDefault
{
  private SendByFile jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
  public HashSet<String> a;
  boolean jdField_a_of_type_Boolean = false;
  public HashSet<String> b;
  boolean b;
  boolean c;
  boolean d = false;
  boolean e;
  public boolean f = false;
  
  PhotoListLogicAIO(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private boolean a()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mPhotoCommonData.selectedPhotoList);
    localIntent.putStringArrayListExtra("input_full_screen_mode_result", localArrayList);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.mPhotoCommonData.currentQualityType);
    return localIntent;
  }
  
  public Intent a(Intent paramIntent)
  {
    Object localObject1 = (HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap");
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (this.mPhotoCommonData.selectedPhotoList.contains(str))
        {
          int i = this.mPhotoCommonData.selectedPhotoList.indexOf(str);
          this.mPhotoCommonData.selectedPhotoList.add(i, ((Map.Entry)localObject2).getValue());
          this.mPhotoCommonData.selectedPhotoList.remove(i + 1);
        }
      }
    }
    localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      ((ArrayList)localObject2).addAll(this.mPhotoCommonData.selectedPhotoList);
    }
    for (;;)
    {
      ((Intent)localObject1).putStringArrayListExtra("input_full_screen_mode_result", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", this.mPhotoCommonData.currentQualityType);
      return localObject1;
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        ((ArrayList)localObject2).addAll(paramIntent);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.d)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100018);
      return;
    }
    super.a(paramIntent);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject = new Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      if (this.mPhotoCommonData.currentQualityType == 2)
      {
        bool = true;
        paramArrayList = ((SendByFile)localObject).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
      }
    }
    for (;;)
    {
      super.a(paramIntent, paramBoolean, (ArrayList)paramArrayList.first);
      return;
      bool = false;
      break;
      ((ArrayList)((Pair)localObject).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject;
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
    if (bool)
    {
      if (paramBoolean)
      {
        String str = paramLocalMediaInfo.path;
        SendByFile localSendByFile;
        AbstractPhotoListActivity localAbstractPhotoListActivity;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
        {
          localSendByFile = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
          localAbstractPhotoListActivity = this.mActivity;
          paramLocalMediaInfo = paramLocalMediaInfo.path;
          if (this.mPhotoCommonData.currentQualityType != 2) {
            break label117;
          }
        }
        label117:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localSendByFile.a(localAbstractPhotoListActivity, paramLocalMediaInfo, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
          if (this.jdField_b_of_type_JavaUtilHashSet.contains(str)) {
            this.jdField_b_of_type_JavaUtilHashSet.remove(str);
          }
          this.jdField_a_of_type_JavaUtilHashSet.add(str);
          return bool;
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramLocalMediaInfo.path))
      {
        this.jdField_a_of_type_JavaUtilHashSet.remove(paramLocalMediaInfo.path);
        return bool;
      }
      this.jdField_b_of_type_JavaUtilHashSet.add(paramLocalMediaInfo.path);
      return bool;
    }
    g();
    return bool;
  }
  
  public void b()
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((this.jdField_a_of_type_Boolean) && (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap != null) && (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
        StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true, this.mPhotoCommonData.selectedPhotoList);
        return;
        if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
          StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          StatisticCollector.getInstance(this.mActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    if (this.d)
    {
      localIntent = a();
      ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
      onBackPressed();
      return;
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (this.mPhotoCommonData.currentQualityType == 2)
    {
      if (localPresendPicMgr != null)
      {
        localPresendPicMgr.a(1008);
        localPresendPicMgr.a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.b();
      c(localIntent);
      return;
      if ((localPresendPicMgr != null) && (!this.f) && (!localIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false)) && (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData))) {
        localPresendPicMgr.a(localIntent);
      }
    }
  }
  
  public void b(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    String str2 = paramIntent.getStringExtra("key_multi_edit_source_path");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(str2, str1);
      ReplacePhotoDataUtil.a(this.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_JavaUtilHashMap, localHashMap);
      this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      int i = this.mPhotoCommonData.selectedPhotoList.indexOf(str2);
      if (i >= 0)
      {
        this.mPhotoCommonData.selectedPhotoList.add(i, str1);
        this.mPhotoCommonData.selectedPhotoList.remove(i + 1);
      }
    }
  }
  
  public void c(Intent paramIntent)
  {
    if (this.f)
    {
      paramIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramIntent.putExtra("session_info", ((NewPhotoListActivity)this.mActivity).getIntent().getParcelableExtra("session_info"));
    }
  }
  
  public void c(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    Object localObject;
    AbstractPhotoListActivity localAbstractPhotoListActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile;
      localAbstractPhotoListActivity = this.mActivity;
      if (this.mPhotoCommonData.currentQualityType != 2) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      ((SendByFile)localObject).a(localAbstractPhotoListActivity, str, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListActivity", 2, "onCheckBoxSelected:path:" + str + ",mMimeType:" + paramLocalMediaInfo.mMimeType);
      }
      localObject = PresendPicMgr.a();
      if ((localObject != null) && (AlbumUtil.getMediaType(paramLocalMediaInfo) == 0)) {
        ((PresendPicMgr)localObject).a(str, 1052, ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance", 0));
      }
      super.c(paramLocalMediaInfo);
      return;
    }
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("key_pic_to_edit_from", 3);
    localIntent.putExtra("input_full_screen_mode", this.d);
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1) {
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label165;
      }
    }
    label165:
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      return super.caseNoSingModeImage(paramView, paramInt);
    }
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    int i = 1;
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1)
    {
      if (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum) {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
    }
    super.caseVideo(paramView, paramInt);
  }
  
  public void d(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b(str, 1013);
    }
    super.d(paramLocalMediaInfo);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a != null)
    {
      int i = PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a);
      ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    paramIntent.putExtra("input_full_screen_mode", this.d);
    super.enterPhotoPreviewActivity(paramBoolean, paramIntent);
  }
  
  public void g()
  {
    if (this.f) {
      ReportController.b(null, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    }
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int j = this.mPhotoCommonData.maxSelectNum;
    paramLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).getResources();
    if (this.d) {}
    for (int i = 2131694868;; i = 2131694869) {
      return paramLocalMediaInfo.getString(i, new Object[] { Integer.valueOf(j) });
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.mPhotoCommonData.needMediaInfo = true;
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.initData(paramIntent);
    this.f = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
    this.e = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (this.e)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
      if (localPresendPicMgr != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "Photo+ send pic,cancel presend!");
        }
        localPresendPicMgr.a(1004);
      }
      PhotoUtils.sendPhoto(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList, this.mPhotoCommonData.currentQualityType, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.isSupportVideoCheckbox = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.isSingleMode = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.e = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.jdField_c_of_type_Boolean = true;
    this.mPhotoCommonData.filter.setSupportWebp(true);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.d = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694896);
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131694852);
    }
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramIntent = new SendByFile().a(((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_Int).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.jdField_b_of_type_Boolean) && (!this.f)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile = paramIntent.a(bool);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && ((paramInt1 == 100017) || (paramInt1 == 100018)))
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 100017: 
        paramIntent = a(paramIntent);
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        return;
      }
      b(paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "current select count:" + localArrayList.size());
    }
    int k = paramView.selectStatus;
    int i;
    if ((k != 1) && (localArrayList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      i = 1;
      if (i == 0) {
        break label206;
      }
    }
    label206:
    for (int j = 2;; j = 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
      if (i == 0) {
        break label212;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramView), 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.lastTimeShowToast = l;
        g();
      }
      return;
      i = 0;
      break;
    }
    label212:
    if ((this.d) && (paramView.fileSize > 31457280L))
    {
      QQToast.a(this.mActivity, 2131694897, 0).b(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      return;
    }
    if (k == 1)
    {
      i = 2;
      paramView.selectStatus = i;
      if (paramView.selectStatus != 1) {
        break label343;
      }
      bool = true;
      label287:
      if (!bool) {
        break label349;
      }
      c(paramView);
      label297:
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (bool) {
        break label357;
      }
    }
    label343:
    label349:
    label357:
    for (boolean bool = true;; bool = false)
    {
      paramView.selectLimitRemind(bool);
      updateButton();
      return;
      i = 1;
      break;
      bool = false;
      break label287;
      d(paramView);
      break label297;
    }
  }
  
  public void onGestureSelectEnd(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super.onGestureSelectEnd(paramBoolean, paramInt1, paramInt2);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((PhotoOtherData)this.mOtherCommonData).a(this.mPhotoCommonData, str) != 1) {
          localPresendPicMgr.a(str, 1052);
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        localPresendPicMgr.b((String)localIterator.next(), 1013);
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent)
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      c(((NewPhotoListActivity)this.mActivity).getIntent());
    }
    super.onMagicStickClick(paramView, paramBundle, paramInt, paramIntent);
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
    ReportController.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile != null)
      {
        if (!this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsSendByFile.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        }
      }
      else
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(0);
        e();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.d) {
        ((NewPhotoListActivity)this.mActivity).b.setVisibility(8);
      }
      return;
      this.jdField_c_of_type_Boolean = false;
      break;
      this.mPhotoCommonData.currentQualityType = 0;
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.mActivity).b.setVisibility(4);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a != null)
    {
      int i = PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a);
      ReportController.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null) {
      localPresendPicMgr.a(1006);
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public List<LocalMediaInfo> queryDoInBackground(Object... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    List localList = super.queryDoInBackground(paramVarArgs);
    this.mPhotoCommonData.mMediaQueryHelper.upDateCount();
    int i = this.mPhotoCommonData.mMediaQueryHelper.cursorsCount;
    HashMap localHashMap;
    boolean bool;
    if (i >= 1000)
    {
      localHashMap = new HashMap();
      l = System.currentTimeMillis() - l;
      if (this.mPhotoCommonData.albumName != null) {
        break label166;
      }
      bool = true;
      if (!bool) {
        break label172;
      }
    }
    label166:
    label172:
    for (paramVarArgs = "1";; paramVarArgs = "0")
    {
      localHashMap.put("isRecent", paramVarArgs);
      localHashMap.put("duration", "" + l);
      localHashMap.put("mediaQuantity", "" + i);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "album_query_media", bool, l, i, localHashMap, null);
      return localList;
      bool = false;
      break;
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.d)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100017);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  public void updateButton()
  {
    super.updateButton();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap == null) || (((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.mPhotoCommonData.selectedPhotoList.size() != ((PhotoOtherData)this.mOtherCommonData).jdField_a_of_type_JavaUtilHashMap.size())) {
          break;
        }
        ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      return;
    }
    if (a())
    {
      ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    Button localButton = ((NewPhotoListActivity)this.mActivity).jdField_a_of_type_AndroidWidgetButton;
    if (this.mPhotoCommonData.selectedPhotoList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAIO
 * JD-Core Version:    0.7.0.1
 */