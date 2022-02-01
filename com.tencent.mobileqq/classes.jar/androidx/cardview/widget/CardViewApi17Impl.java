package androidx.cardview.widget;

import androidx.annotation.RequiresApi;

@RequiresApi(17)
class CardViewApi17Impl
  extends CardViewBaseImpl
{
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new CardViewApi17Impl.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.cardview.widget.CardViewApi17Impl
 * JD-Core Version:    0.7.0.1
 */