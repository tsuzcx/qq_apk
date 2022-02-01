package com.tencent.mobileqq.activity.history;

import aicv;
import aicy;
import aidw;
import akdi;
import akdj;
import akdk;
import akdl;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bdll;
import bgri;
import bgrl;
import bgrm;
import bhpc;
import bhrl;
import blir;
import blji;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryTroopMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private bgrm a;
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      aicy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void a(ArrayList<aidw> paramArrayList)
  {
    Object localObject = bhrl.a();
    String str1 = a();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new bhpc(getActivity(), 2131755824);
      paramArrayList.setContentView(2131559008);
      paramArrayList.setTitle(getActivity().getString(2131696995));
      paramArrayList.setMessage(getActivity().getString(2131696993));
      paramArrayList.setNegativeButton(getActivity().getString(2131696994), new akdj(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getActivity(), 2131692409, 0).a();
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
  
  void a(ArrayList<aidw> paramArrayList, String paramString1, String paramString2)
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
      Object localObject = (aidw)paramArrayList.next();
      if (AIOImageData.class.isInstance(((aidw)localObject).a))
      {
        localObject = (AIOImageData)((aidw)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    aicv.a(getActivity(), bhrl.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  public void b(ArrayList<aidw> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    aicv.a(getActivity(), bhrl.a(), a(), 0, (List)paramArrayList.clone(), true, a());
  }
  
  public void e()
  {
    super.e();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bgrm != null)
    {
      bgri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
      this.jdField_a_of_type_Bgrm = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bgrm != null)
    {
      bgri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
      this.jdField_a_of_type_Bgrm = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bgrm == null)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new akdl(this, Long.parseLong((String)localObject));
        this.jdField_a_of_type_Bgrm = new akdk(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bgrl)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    if (this.jdField_a_of_type_Bgrm != null) {
      bgri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
    }
  }
  
  protected void q()
  {
    x();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void u()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  protected void x()
  {
    int k = 0;
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(2131689886);
    localblir.a(2131689887, 5);
    int m = d();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((aidw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((aidw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localblir.b(2131692969);
        }
        if ((m == 1) && (j == 0)) {
          localblir.a(2131692963, 5);
        }
        localblir.c(2131690580);
        localblir.a(new akdi(this, localblir, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
        localblir.show();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */