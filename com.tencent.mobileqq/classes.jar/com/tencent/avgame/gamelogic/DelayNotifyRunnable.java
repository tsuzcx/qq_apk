package com.tencent.avgame.gamelogic;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.AppInterface;

public class DelayNotifyRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  DelayNotifyRunnable.IOnDelayNotifyDoneListener jdField_a_of_type_ComTencentAvgameGamelogicDelayNotifyRunnable$IOnDelayNotifyDoneListener;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject;
  boolean jdField_a_of_type_Boolean = false;
  
  public DelayNotifyRunnable(AppInterface paramAppInterface, int paramInt, DelayNotifyRunnable.IOnDelayNotifyDoneListener paramIOnDelayNotifyDoneListener, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDelayNotifyRunnable$IOnDelayNotifyDoneListener = paramIOnDelayNotifyDoneListener;
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicDelayNotifyRunnable$IOnDelayNotifyDoneListener.a(this.jdField_a_of_type_Int, new Object[] { paramObject, Integer.valueOf(i), localObject });
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
    str = GameEngine.a().a().a().getNick(str);
    this.jdField_a_of_type_ComTencentAvgameGamelogicDelayNotifyRunnable$IOnDelayNotifyDoneListener.a(this.jdField_a_of_type_Int, new Object[] { str, Integer.valueOf(i), localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.DelayNotifyRunnable
 * JD-Core Version:    0.7.0.1
 */