package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import java.util.ArrayList;

final class FastWebAdtUtil$1
  implements Runnable
{
  FastWebAdtUtil$1(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, long paramLong, String paramString7, int paramInt2, ResponseCallback paramResponseCallback) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = FastWebAdtUtil.a(FastWebAdtUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e, this.f, this.jdField_a_of_type_Boolean, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long), FastWebAdtUtil.a(this.g, this.jdField_b_of_type_Int));
    boolean bool;
    if ((localObject != null) && (FastWebAdtUtil.a((String)localObject, this.jdField_b_of_type_JavaLangString, localArrayList, ReadInJoyAdInnerUtils.a(this.jdField_a_of_type_JavaLangString, this.d, this.g))))
    {
      FastWebAdtUtil.d(localArrayList);
      bool = true;
    }
    else
    {
      bool = false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebResponseCallback;
    if (localObject != null) {
      ((ResponseCallback)localObject).a(bool, localArrayList, true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAdtUtil.1
 * JD-Core Version:    0.7.0.1
 */