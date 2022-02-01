package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class ArkHorizontalListViewAdapter$2
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkHorizontalListViewAdapter$2(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, String paramString, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null))
    {
      ArkAppCacheMgr.getAppIcon(this.jdField_a_of_type_JavaLangString, new ArkHorizontalListViewAdapter.2.1(this));
      paramString = ArkAppCacheMgr.getApplicationDesc(this.jdField_a_of_type_JavaLangString);
      ArkAppCenter.a().postToMainThread(new ArkHorizontalListViewAdapter.2.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.2
 * JD-Core Version:    0.7.0.1
 */