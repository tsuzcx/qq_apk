package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
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
    Object localObject = QQUtils.a();
    String str1 = a();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new QQCustomDialog(getActivity(), 2131755842);
      paramArrayList.setContentView(2131559084);
      paramArrayList.setTitle(getActivity().getString(2131697668));
      paramArrayList.setMessage(getActivity().getString(2131697666));
      paramArrayList.setNegativeButton(getActivity().getString(2131697667), new ChatHistoryTroopMediaFragment.2(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getActivity(), 2131692696, 0).a();
      return;
    }
    str1 = getActivity().getIntent().getStringExtra("UploadPhoto.key_album_id");
    String str2 = getActivity().getIntent().getStringExtra("UploadPhoto.key_album_name");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("forwardToGroupAlbum, albumId = ");
      if (str1 == null) {
        break label261;
      }
      localObject = str1;
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , albumName = ");
      if (str2 == null) {
        break label267;
      }
    }
    label261:
    label267:
    for (localObject = str2;; localObject = "null")
    {
      QLog.d("ChatHistoryMediaBaseFragment", 2, (String)localObject);
      a(paramArrayList, str1, str2);
      return;
      localObject = "null";
      break;
    }
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
    AIOGalleryUtils.a(getActivity(), QQUtils.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  void b(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(getActivity(), QQUtils.a(), a(), 0, (List)paramArrayList.clone(), true, a());
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
    int k = 0;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.setMainTitle(2131689971);
    localActionSheet.addButton(2131689972, 5);
    int m = d();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localActionSheet.addButton(2131693309);
        }
        if ((m == 1) && (j == 0)) {
          localActionSheet.addButton(2131693303, 5);
        }
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new ChatHistoryTroopMediaFragment.1(this, localActionSheet, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
        localActionSheet.show();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */