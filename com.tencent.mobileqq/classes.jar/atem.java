import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class atem
  extends amab
{
  atem(atei paramatei) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      atei.a(this.a, 2131693803);
    }
    this.a.jdField_a_of_type_Int = -1;
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      switch (paramInt2)
      {
      case -1: 
      default: 
        atei.a(this.a, 2131693803);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = -1;
      return;
      if ((this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 5))
      {
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
      else
      {
        atei.a(this.a, 2131693804, 2);
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0,\"message\":\"ok\"}" });
        continue;
        atei.a(this.a, 2131721045);
        continue;
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.b == 0) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret success.");
      }
      paramLong = paramTroopInfo.troopPrivilegeFlag;
      if ((0x80 & paramLong) != 0L)
      {
        paramInt1 = 1;
        if ((paramLong & 0x200) == 0L) {
          break label110;
        }
        paramInt2 = 1;
        label61:
        paramString = atei.a(this.a);
        if ((paramInt1 == 0) || (paramInt2 == 0) || (paramString == null)) {
          break label116;
        }
        ahla.a(paramString, paramTroopInfo.troopuin);
      }
    }
    for (;;)
    {
      this.a.b = 0;
      return;
      paramInt1 = 0;
      break;
      label110:
      paramInt2 = 0;
      break label61;
      label116:
      if (paramTroopInfo.cGroupOption == 1)
      {
        this.a.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
        atei.a(this.a, paramTroopInfo);
      }
      else
      {
        atei.b(this.a, paramTroopInfo);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret failed.");
        }
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
        atei.a(this.a, 2131719221);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atem
 * JD-Core Version:    0.7.0.1
 */