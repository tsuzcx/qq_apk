package com.tencent.mobileqq.activity.history;

import aehw;
import aeid;
import aeiy;
import afyy;
import afyz;
import afza;
import afzb;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import axqy;
import bajt;
import bajw;
import bajx;
import bbgu;
import bbjc;
import bcql;
import bfpc;
import bfpp;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryTroopMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private bajx a;
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      aeid.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent);
    }
  }
  
  public void a(ArrayList<aeiy> paramArrayList)
  {
    Object localObject = bbjc.a();
    String str1 = a();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new bbgu(getActivity(), 2131755791);
      paramArrayList.setContentView(2131558906);
      paramArrayList.setTitle(getActivity().getString(2131697920));
      paramArrayList.setMessage(getActivity().getString(2131697918));
      paramArrayList.setNegativeButton(getActivity().getString(2131697919), new afyz(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      bcql.a(getActivity(), 2131692767, 0).a();
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
  
  void a(ArrayList<aeiy> paramArrayList, String paramString1, String paramString2)
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
      Object localObject = (aeiy)paramArrayList.next();
      if (AIOImageData.class.isInstance(((aeiy)localObject).a))
      {
        localObject = (AIOImageData)((aeiy)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).e);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).c));
      }
    }
    aehw.a(getActivity(), bbjc.a(), a(), a(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  public void b(ArrayList<aeiy> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    aehw.a(getActivity(), bbjc.a(), a(), 0, (List)paramArrayList.clone(), true, a());
  }
  
  public void e()
  {
    super.e();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bajx != null)
    {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
      this.jdField_a_of_type_Bajx = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bajx != null)
    {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
      this.jdField_a_of_type_Bajx = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bajx == null)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new afzb(this, Long.parseLong((String)localObject));
        this.jdField_a_of_type_Bajx = new afza(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bajw)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    if (this.jdField_a_of_type_Bajx != null) {
      bajt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
    }
  }
  
  protected void p()
  {
    w();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void q()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void r()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void s()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void t()
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  protected void w()
  {
    int k = 0;
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    localbfpc.a(2131689935);
    localbfpc.a(2131689936, 5);
    int m = d();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((((aeiy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((aeiy)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a).e == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localbfpc.b(2131693397);
        }
        if ((m == 1) && (j == 0)) {
          localbfpc.a(2131693385, 5);
        }
        localbfpc.c(2131690596);
        localbfpc.a(new afyy(this, localbfpc, (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone()));
        localbfpc.show();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */