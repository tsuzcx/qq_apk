package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class TroopAddFrdsInnerFrame$3
  extends TroopBusinessObserver
{
  TroopAddFrdsInnerFrame$3(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    if ((paramBoolean1) && (this.a.a != null) && (this.a.a.longValue() == paramLong) && (paramString1.equals(this.a.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onTroopBatchReqMemberCmnFrds suc. troopUin:%s, cmnfrds.size:%d", new Object[] { paramString1, Integer.valueOf(paramHashMap.size()) }));
      }
      if (paramHashMap.size() > 0)
      {
        paramString1 = this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(6);
        paramString1.obj = paramHashMap;
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.3
 * JD-Core Version:    0.7.0.1
 */