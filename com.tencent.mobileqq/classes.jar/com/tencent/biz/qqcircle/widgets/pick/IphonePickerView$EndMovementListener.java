package com.tencent.biz.qqcircle.widgets.pick;

class IphonePickerView$EndMovementListener
  implements VerticalGallery.OnEndMovementListener
{
  private int b;
  
  public IphonePickerView$EndMovementListener(IphonePickerView paramIphonePickerView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    int i = IphonePickerView.c(this.a)[this.b].getSelectedItemPosition();
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).a(this.b, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.EndMovementListener
 * JD-Core Version:    0.7.0.1
 */