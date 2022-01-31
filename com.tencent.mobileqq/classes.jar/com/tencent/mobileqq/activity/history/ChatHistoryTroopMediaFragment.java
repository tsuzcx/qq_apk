package com.tencent.mobileqq.activity.history;

import agem;
import aget;
import agfq;
import ahww;
import ahwx;
import ahwy;
import ahwz;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import azmj;
import bcig;
import bcij;
import bcik;
import bdfq;
import bdhy;
import bhpy;
import bhql;
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
  private bcik a;
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      aget.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void a(ArrayList<agfq> paramArrayList)
  {
    Object localObject = bdhy.a();
    String str1 = a();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new bdfq(getActivity(), 2131755801);
      paramArrayList.setContentView(2131558943);
      paramArrayList.setTitle(getActivity().getString(2131698097));
      paramArrayList.setMessage(getActivity().getString(2131698095));
      paramArrayList.setNegativeButton(getActivity().getString(2131698096), new ahwx(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getActivity(), 2131692849, 0).a();
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
  
  void a(ArrayList<agfq> paramArrayList, String paramString1, String paramString2)
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
      Object localObject = (agfq)paramArrayList.next();
      if (AIOImageData.class.isInstance(((agfq)localObject).a))
      {
        localObject = (AIOImageData)((agfq)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    agem.a(getActivity(), bdhy.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  public void b(ArrayList<agfq> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    agem.a(getActivity(), bdhy.a(), a(), 0, (List)paramArrayList.clone(), true, a());
  }
  
  public void e()
  {
    super.e();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bcik != null)
    {
      bcig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
      this.jdField_a_of_type_Bcik = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bcik != null)
    {
      bcig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
      this.jdField_a_of_type_Bcik = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bcik == null)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ahwz(this, Long.parseLong((String)localObject));
        this.jdField_a_of_type_Bcik = new ahwy(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bcij)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    if (this.jdField_a_of_type_Bcik != null) {
      bcig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
    }
  }
  
  protected void p()
  {
    w();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void q()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  protected void w()
  {
    int k = 0;
    bhpy localbhpy = (bhpy)bhql.a(getActivity(), null);
    localbhpy.a(2131689982);
    localbhpy.a(2131689983, 5);
    int m = d();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((agfq)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbhpy.b(2131693498);
        }
        if ((m == 1) && (j == 0)) {
          localbhpy.a(2131693486, 5);
        }
        localbhpy.c(2131690648);
        localbhpy.a(new ahww(this, localbhpy, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
        localbhpy.show();
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