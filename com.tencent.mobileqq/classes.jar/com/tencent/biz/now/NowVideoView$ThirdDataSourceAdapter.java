package com.tencent.biz.now;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class NowVideoView$ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  int a = 0;
  String b;
  AbsThirdDataSourceAdapter.OnPreparedCallback c;
  
  public NowVideoView$ThirdDataSourceAdapter(NowVideoView paramNowVideoView) {}
  
  public boolean a()
  {
    if (!this.d.f.a(this.d.k.frienduin, this.d.k.time)) {
      return true;
    }
    if (this.d.i.size() > 0)
    {
      String str = (String)this.d.i.get(this.d.i.size() - 1);
      this.a = 2;
      this.b = str;
      if ((this.c != null) && (this.d.p == 0))
      {
        this.c.onPrepared();
        return true;
      }
    }
    return false;
  }
  
  public int getPlayType()
  {
    return 1;
  }
  
  public int getStaus()
  {
    return this.a;
  }
  
  public String getURL()
  {
    return this.b;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.c = paramOnPreparedCallback;
    if (this.d.i.size() > 0)
    {
      paramString = (String)this.d.i.get(this.d.i.size() - 1);
      this.a = 2;
      this.b = paramString;
      paramOnPreparedCallback.onPrepared();
      return;
    }
    this.a = 1;
    this.d.f.a(this.d.k.frienduin, this.d.c, this.d.k.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.ThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */