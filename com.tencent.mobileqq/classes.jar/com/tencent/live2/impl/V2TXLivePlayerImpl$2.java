package com.tencent.live2.impl;

import android.view.Surface;
import com.tencent.live2.V2TXLivePlayer;
import java.util.HashMap;

class V2TXLivePlayerImpl$2
  implements Runnable
{
  V2TXLivePlayerImpl$2(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, String paramString, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.val$key;
    switch (((String)localObject).hashCode())
    {
    default: 
      break;
    case 1120433643: 
      if (((String)localObject).equals("setSurface")) {
        i = 0;
      }
      break;
    case 787234457: 
      if (((String)localObject).equals("enableRecvSEIMessage")) {
        i = 3;
      }
      break;
    case 480042124: 
      if (((String)localObject).equals("setSurfaceSize")) {
        i = 1;
      }
      break;
    case 190314931: 
      if (((String)localObject).equals("setPlayURLType")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) || (i == 3)) {
          V2TXLivePlayerImpl.access$400(this.this$0).put(this.val$key, this.val$value);
        }
      }
      else
      {
        localObject = this.val$value;
        if (localObject == null) {
          V2TXLivePlayerImpl.access$302(this.this$0, null);
        } else if ((localObject instanceof a.a)) {
          V2TXLivePlayerImpl.access$302(this.this$0, (a.a)localObject);
        }
      }
    }
    else
    {
      localObject = this.val$value;
      if (localObject == null) {
        V2TXLivePlayerImpl.access$202(this.this$0, null);
      } else if ((localObject instanceof Surface)) {
        V2TXLivePlayerImpl.access$202(this.this$0, (Surface)localObject);
      }
    }
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setProperty(this.val$key, this.val$value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */