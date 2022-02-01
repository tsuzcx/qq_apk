package com.tencent.aelight.camera.aebase;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class PhotoListCustomizationAECircle
  extends PhotoListCustomizationDefault
{
  private static final int jdField_a_of_type_Int = ;
  public static final String a = "com.tencent.aelight.camera.aebase.PhotoListCustomizationAECircle";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 3000;
  private int d = 3000;
  private int e = 3600000;
  private int f;
  
  public PhotoListCustomizationAECircle(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    AEQLog.a("PhotoListCustomizationAECircle", "[AE Profiler] PhotoListCustomizationAECircle new");
  }
  
  /* Error */
  private int a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 66	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   4: lstore_3
    //   5: lload_3
    //   6: aload_0
    //   7: getfield 48	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:e	I
    //   10: i2l
    //   11: lcmp
    //   12: ifgt +110 -> 122
    //   15: lload_3
    //   16: ldc2_w 67
    //   19: lcmp
    //   20: ifge +5 -> 25
    //   23: iconst_1
    //   24: ireturn
    //   25: new 70	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 72	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_1
    //   37: getfield 75	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   40: invokevirtual 79	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   43: aload 6
    //   45: bipush 12
    //   47: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: getstatic 34	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   55: iconst_0
    //   56: aaload
    //   57: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +28 -> 88
    //   63: aload_1
    //   64: getstatic 34	com/tencent/aelight/camera/aebase/PhotoListCustomizationAECircle:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   67: iconst_1
    //   68: aaload
    //   69: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +12 -> 88
    //   79: iconst_3
    //   80: istore_2
    //   81: aload 6
    //   83: invokevirtual 90	android/media/MediaMetadataRetriever:release	()V
    //   86: iload_2
    //   87: ireturn
    //   88: aload 6
    //   90: invokevirtual 90	android/media/MediaMetadataRetriever:release	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_1
    //   96: goto +19 -> 115
    //   99: astore_1
    //   100: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   110: iconst_5
    //   111: istore_2
    //   112: goto -31 -> 81
    //   115: aload 6
    //   117: invokevirtual 90	android/media/MediaMetadataRetriever:release	()V
    //   120: aload_1
    //   121: athrow
    //   122: iconst_1
    //   123: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	PhotoListCustomizationAECircle
    //   0	124	1	paramLocalMediaInfo	LocalMediaInfo
    //   80	32	2	i	int
    //   4	12	3	l	long
    //   72	3	5	bool	boolean
    //   32	84	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   34	74	95	finally
    //   100	110	95	finally
    //   34	74	99	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 2131756189);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  private void d()
  {
    AEEditorJumpUtil.a(this.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    b(false);
  }
  
  public Intent a(View paramView, int paramInt)
  {
    paramView = super.a(paramView, paramInt);
    paramView.putExtra("choosed_num", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size());
    paramView.putExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", this.f);
    LocalMediaInfo localLocalMediaInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.size();
    int k = 0;
    int j = paramInt;
    int m;
    for (int i = 0; k < i1; i = m)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList.get(k);
      LocalMediaInfo localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
      int n = j;
      m = i;
      if (AlbumUtil.getMediaType(localLocalMediaInfo2) == 0)
      {
        localArrayList1.add(str);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.contains(str))) {
          localArrayList2.add(Integer.valueOf(i));
        }
        if (localLocalMediaInfo2.position.intValue() == paramInt) {
          j = i;
        }
        m = i + 1;
        n = j;
      }
      k += 1;
      j = n;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList = localArrayList1;
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList1);
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", localArrayList2);
    if (AlbumUtil.getMediaType(localLocalMediaInfo1) == 0) {
      paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", j);
    }
    return paramView;
  }
  
  public void a()
  {
    super.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2131716583);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum - this.f);
    str = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setText(str);
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850104);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837911);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 10019))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    }
  }
  
  public void a(Intent paramIntent)
  {
    AEResUtil.a();
    super.a(paramIntent);
    int i = AECameraEntry.y.a();
    if (AECameraEntryManager.m(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent())) {
      i = AECameraEntry.A.a();
    }
    AEBaseReportParam.a().a(i, null);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getStringExtra("intent_key_uid_for_report");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = AECaptureContext.a().getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().putExtra("intent_key_uid_for_report", (String)localObject);
    }
    AEBaseReportParam.a().c((String)localObject);
    AEBaseReportParam.a().b();
    AEBaseReportParam.a().a();
    AEBaseReportParam.a().d(CameraOperationHelper.a(null));
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getStringExtra("albumName");
    str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.f = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AdditionalPick] initData---initialHasPickedNum=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(", canPickVideo=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    AEQLog.a("PhotoListCustomizationAECircle", ((StringBuilder)localObject).toString());
    this.c = 3000;
    this.d = 3000;
    this.e = jdField_a_of_type_Int;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("qq_camera_from_qcircle_scheme"))) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 0, HardCodeUtil.a(2131689707), 1).a();
    }
    AEReportUtils.a(false);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    d();
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (localLocalMediaInfo.selectStatus != 1)
    {
      int j = this.b;
      if (j == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (i == 0) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689735), 0).a();
          }
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0)
        {
          if (i == 0) {
            this.b = 0;
          }
        }
        else {
          AEQLog.d("PhotoListCustomizationAECircle", "[error] size > 1 && mDataType = video");
        }
      }
      else if (j == 0)
      {
        if (i == 0)
        {
          if (QAlbumUtil.isGif(localLocalMediaInfo))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689733), 0).a();
            return;
          }
          if ((localLocalMediaInfo.mediaWidth >= 20) && (localLocalMediaInfo.mediaHeight >= 20))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.f >= 9)
            {
              paramView = BaseApplicationImpl.sApplication.getResources().getString(2131689734, new Object[] { Integer.valueOf(9 - this.f) });
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramView, 0).a();
            }
          }
          else {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689732), 0).a();
          }
        }
      }
      else
      {
        AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
      }
    }
    else
    {
      i = this.b;
      if (i == 1) {
        this.b = 0;
      } else if (i != 0) {
        AEQLog.d("PhotoListCustomizationAECircle", "[error] no know mDataType~");
      }
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QAlbumUtil.isGif(paramLocalMediaInfo))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689733), 0).a();
      return false;
    }
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.n) && (arrayOfString != null) && (!"image".equals(arrayOfString[0]))) {
      return false;
    }
    int i = paramLocalMediaInfo.selectStatus;
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {
      return false;
    }
    if ((i == 2) && (paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.f >= 9))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b >= 700L)
      {
        paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2131689734, new Object[] { Integer.valueOf(9 - this.f) });
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramLocalMediaInfo, 0).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b = l;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.p = true;
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.p = false;
    if (paramBoolean) {
      a(paramLocalMediaInfo);
    } else {
      b(paramLocalMediaInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.b(paramBoolean ^ true);
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList)
  {
    return super.a(paramList);
  }
  
  public void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivityForResult(paramIntent, 10019);
  }
  
  public void b(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    } else {
      i = 0;
    }
    StatisticConstants.b(paramView, i);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    String str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (str1 == null) {
      return;
    }
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.startActivity(paramView);
    }
    else
    {
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
        QZoneHelper.launchQZone(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, str3, paramView, 2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, false, false);
  }
  
  public void b(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) && (this.jdField_a_of_type_Boolean))
    {
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
      int i = a(localLocalMediaInfo);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  return;
                }
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689739), 0).a();
                return;
              }
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689736), 0).a();
              return;
            }
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689738), 0).a();
            return;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689737), 0).a();
          return;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, String.format(HardCodeUtil.a(2131689731), new Object[] { Integer.valueOf(2), Integer.valueOf(jdField_a_of_type_Int / 60 / 1000) }), 0).a();
        return;
      }
      this.b = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      Object localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, paramView);
      }
      paramView.put(localLocalMediaInfo.path, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(localLocalMediaInfo.path))
      {
        localObject = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        paramView.put(localLocalMediaInfo.path, localObject);
      }
      d();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, HardCodeUtil.a(2131689735), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PhotoListCustomizationAECircle
 * JD-Core Version:    0.7.0.1
 */