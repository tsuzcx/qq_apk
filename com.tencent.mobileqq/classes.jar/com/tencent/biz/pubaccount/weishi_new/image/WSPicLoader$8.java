package com.tencent.biz.pubaccount.weishi_new.image;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.List;

final class WSPicLoader$8
  implements Runnable
{
  WSPicLoader$8(List paramList, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(i);
      String str = WeishiUtils.a((stSimpleMetaFeed)localObject, this.jdField_a_of_type_Boolean);
      if (!TextUtils.isEmpty(str))
      {
        localObject = WeishiUIUtil.a((stSimpleMetaFeed)localObject);
        WSPicLoader.a(str, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), this.jdField_a_of_type_JavaLangString, i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.8
 * JD-Core Version:    0.7.0.1
 */