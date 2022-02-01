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
    Object localObject = FastWebAdtUtil.a(FastWebAdtUtil.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, 2, this.h, this.i), FastWebAdtUtil.a(this.j, this.k));
    boolean bool;
    if ((localObject != null) && (FastWebAdtUtil.a((String)localObject, this.b, localArrayList, ReadInJoyAdInnerUtils.a(this.a, this.d, this.j))))
    {
      FastWebAdtUtil.d(localArrayList);
      bool = true;
    }
    else
    {
      bool = false;
    }
    localObject = this.l;
    if (localObject != null) {
      ((ResponseCallback)localObject).a(bool, localArrayList, true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAdtUtil.1
 * JD-Core Version:    0.7.0.1
 */