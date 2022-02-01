package com.tencent.biz.pubaccount.weishi_new.player;

final class WSPlayerUtils$1
  implements WSPlayerUtils.OnCalculateLayoutListener
{
  WSPlayerUtils$1(WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams, WSPlayerUtils.OnCalculateLayoutListener paramOnCalculateLayoutListener) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    WSPlayerUtils.a(this.a.a, paramInt1);
    WSPlayerUtils.a(this.a.b, paramInt2, paramInt3);
    WSPlayerUtils.OnCalculateLayoutListener localOnCalculateLayoutListener = this.b;
    if (localOnCalculateLayoutListener != null) {
      localOnCalculateLayoutListener.a(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.1
 * JD-Core Version:    0.7.0.1
 */