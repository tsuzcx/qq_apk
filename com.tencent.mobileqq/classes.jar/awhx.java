import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class awhx
  extends aojs
{
  awhx(awhv paramawhv) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Int == -1) {
      return;
    }
    if (1 == paramInt1) {
      awhv.a(this.a, 2131693156);
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
        awhv.a(this.a, 2131693156);
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
        awhv.a(this.a, 2131693157, 2);
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0,\"message\":\"ok\"}" });
        continue;
        awhv.a(this.a, 2131718941);
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
          break label112;
        }
        paramInt2 = 1;
        label61:
        paramString = awhv.a(this.a);
        if ((paramInt1 == 0) || (paramInt2 == 0) || (paramString == null)) {
          break label118;
        }
        ajpz.a(paramString, paramTroopInfo.troopuin, "");
      }
    }
    for (;;)
    {
      this.a.b = 0;
      return;
      paramInt1 = 0;
      break;
      label112:
      paramInt2 = 0;
      break label61;
      label118:
      if (paramTroopInfo.cGroupOption == 1)
      {
        this.a.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
        awhv.a(this.a, paramTroopInfo);
      }
      else
      {
        awhv.b(this.a, paramTroopInfo);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret failed.");
        }
        this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
        awhv.a(this.a, 2131717454);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhx
 * JD-Core Version:    0.7.0.1
 */