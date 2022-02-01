package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryTroopMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private TroopFileError.TroopFileErrorObserver a;
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    Object localObject1 = QQUtils.a();
    String str1 = a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("__qzone_pic_permission__");
    ((StringBuilder)localObject2).append(str1);
    if (LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject2).toString(), -1, Long.valueOf((String)localObject1).longValue()) == 0)
    {
      paramArrayList = new QQCustomDialog(getBaseActivity(), 2131756189);
      paramArrayList.setContentView(2131558978);
      paramArrayList.setTitle(getBaseActivity().getString(2131697674));
      paramArrayList.setMessage(getBaseActivity().getString(2131697672));
      paramArrayList.setNegativeButton(getBaseActivity().getString(2131697673), new ChatHistoryTroopMediaFragment.2(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject1, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getBaseActivity(), 2131692653, 0).a();
      return;
    }
    str1 = getBaseActivity().getIntent().getStringExtra("UploadPhoto.key_album_id");
    localObject2 = getBaseActivity().getIntent().getStringExtra("UploadPhoto.key_album_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forwardToGroupAlbum, albumId = ");
      String str2 = "null";
      if (str1 != null) {
        localObject1 = str1;
      } else {
        localObject1 = "null";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" , albumName = ");
      localObject1 = str2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("ChatHistoryMediaBaseFragment", 2, localStringBuilder.toString());
    }
    a(paramArrayList, str1, (String)localObject2);
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (AIORichMediaInfo)paramArrayList.next();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    AIOGalleryUtils.a(getBaseActivity(), QQUtils.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  void b(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(getBaseActivity(), QQUtils.a(), a(), 0, (List)paramArrayList.clone(), true, a());
  }
  
  public void e()
  {
    super.e();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ChatHistoryTroopMediaFragment.TroopFileErrorFilter(this, Long.parseLong((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new ChatHistoryTroopMediaFragment.MediaTroopFileErrorObserver(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (TroopFileError.TroopFileErrorFilter)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
  }
  
  protected void q()
  {
    x();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void u()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  protected void x()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
    localActionSheet.setMainTitle(2131689886);
    localActionSheet.addButton(2131689887, 5);
    int m = d();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      if (((((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131693263);
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131693257, 5);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ChatHistoryTroopMediaFragment.1(this, localActionSheet, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */