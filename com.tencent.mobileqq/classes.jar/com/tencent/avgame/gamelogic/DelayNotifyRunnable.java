package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.AppInterface;
import nfb;
import nfc;
import nfv;

public class DelayNotifyRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject;
  nfb jdField_a_of_type_Nfb;
  boolean jdField_a_of_type_Boolean = false;
  
  public DelayNotifyRunnable(AppInterface paramAppInterface, int paramInt, nfb paramnfb, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Nfb = paramnfb;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public Object a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return (String)((Object[])(Object[])this.jdField_a_of_type_JavaLangObject)[0];
    }
    return null;
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Int != 0);
    Object localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
    String str = (String)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = (String)localObject[2];
    paramObject = (String)paramObject;
    this.jdField_a_of_type_Nfb.a(this.jdField_a_of_type_Int, new Object[] { paramObject, Integer.valueOf(i), localObject });
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Int != 0);
    Object localObject = (Object[])this.jdField_a_of_type_JavaLangObject;
    String str = (String)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = (String)localObject[2];
    str = nfc.a().a().a().getNick(str);
    this.jdField_a_of_type_Nfb.a(this.jdField_a_of_type_Int, new Object[] { str, Integer.valueOf(i), localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.DelayNotifyRunnable
 * JD-Core Version:    0.7.0.1
 */