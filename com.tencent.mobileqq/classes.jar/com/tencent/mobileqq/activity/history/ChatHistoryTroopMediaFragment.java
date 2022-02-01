package com.tencent.mobileqq.activity.history;

import ahsl;
import ahso;
import ahtm;
import ajtx;
import ajty;
import ajtz;
import ajua;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bdla;
import bgjc;
import bgjf;
import bgjg;
import bhgy;
import bkzi;
import bkzz;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  private bgjg a;
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      ahso.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void a(ArrayList<ahtm> paramArrayList)
  {
    Object localObject = bhgy.a();
    String str1 = a();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new QQCustomDialog(getActivity(), 2131755829);
      paramArrayList.setContentView(2131559043);
      paramArrayList.setTitle(getActivity().getString(2131697414));
      paramArrayList.setMessage(getActivity().getString(2131697412));
      paramArrayList.setNegativeButton(getActivity().getString(2131697413), new ajty(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getActivity(), 2131692559, 0).a();
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
  
  void a(ArrayList<ahtm> paramArrayList, String paramString1, String paramString2)
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
      Object localObject = (ahtm)paramArrayList.next();
      if (AIOImageData.class.isInstance(((ahtm)localObject).a))
      {
        localObject = (AIOImageData)((ahtm)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    ahsl.a(getActivity(), bhgy.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  public void b(ArrayList<ahtm> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    ahsl.a(getActivity(), bhgy.a(), a(), 0, (List)paramArrayList.clone(), true, a());
  }
  
  public void e()
  {
    super.e();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bgjg != null)
    {
      bgjc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
      this.jdField_a_of_type_Bgjg = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bgjg != null)
    {
      bgjc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
      this.jdField_a_of_type_Bgjg = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bgjg == null)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ajua(this, Long.parseLong((String)localObject));
        this.jdField_a_of_type_Bgjg = new ajtz(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bgjf)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    if (this.jdField_a_of_type_Bgjg != null) {
      bgjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
    }
  }
  
  protected void q()
  {
    x();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void u()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  protected void x()
  {
    int k = 0;
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    localbkzi.a(2131689929);
    localbkzi.a(2131689930, 5);
    int m = d();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((ahtm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((ahtm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbkzi.b(2131693160);
        }
        if ((m == 1) && (j == 0)) {
          localbkzi.a(2131693154, 5);
        }
        localbkzi.c(2131690697);
        localbkzi.a(new ajtx(this, localbkzi, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
        localbkzi.show();
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