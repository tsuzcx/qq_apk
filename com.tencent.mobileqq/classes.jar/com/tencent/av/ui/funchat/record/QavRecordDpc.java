package com.tencent.av.ui.funchat.record;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class QavRecordDpc
{
  private static QavRecordDpc a;
  public int a;
  public String a;
  public int b = 4;
  public int c = 2000;
  public int d = 4;
  public int e = 2150;
  public int f = 720;
  public int g = 1;
  public int h = 5;
  public int i = 1;
  public int j = 120000;
  public int k = 1;
  public int l;
  public int m;
  
  public QavRecordDpc()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  private static int a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramInt1 >= paramArrayOfString.length)) {
      return paramInt2;
    }
    try
    {
      paramInt1 = Integer.parseInt(paramArrayOfString[paramInt1]);
      return paramInt1;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return paramInt2;
  }
  
  public static QavRecordDpc a()
  {
    if (jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc == null) {
      jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc = b();
    }
    return jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordDpc;
  }
  
  private static QavRecordDpc b()
  {
    QavRecordDpc localQavRecordDpc = new QavRecordDpc();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qavDpc.name());
    localQavRecordDpc.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (!TextUtils.isEmpty(localQavRecordDpc.jdField_a_of_type_JavaLangString))
    {
      localObject = ((String)localObject).split("\\|");
      localQavRecordDpc.jdField_a_of_type_Int = a((String[])localObject, 0, 1);
      localQavRecordDpc.b = a((String[])localObject, 1, 4);
      localQavRecordDpc.c = a((String[])localObject, 2, 2000);
      localQavRecordDpc.d = a((String[])localObject, 3, 4);
      localQavRecordDpc.e = a((String[])localObject, 4, 2150);
      localQavRecordDpc.f = a((String[])localObject, 5, 720);
      localQavRecordDpc.g = a((String[])localObject, 6, 1);
      localQavRecordDpc.h = a((String[])localObject, 7, 5);
      localQavRecordDpc.j = a((String[])localObject, 8, 120000);
      localQavRecordDpc.i = a((String[])localObject, 9, 1);
      localQavRecordDpc.k = a((String[])localObject, 10, 1);
    }
    localQavRecordDpc.l = DeviceInfoUtil.b();
    localQavRecordDpc.m = ((int)(DeviceInfoUtil.b() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QavRecordDpc", 2, "init=" + localQavRecordDpc);
    }
    return localQavRecordDpc;
  }
  
  public String toString()
  {
    return String.format(Locale.getDefault(), "QavRecordDpc:dpc=%s, default=%d|%d|%d|%d|%d|%d, value=%d|%d|%d|%d|%d|%d|%d|%d|%d|%d, system=%d|%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2000), Integer.valueOf(4), Integer.valueOf(2150), Integer.valueOf(720), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordDpc
 * JD-Core Version:    0.7.0.1
 */