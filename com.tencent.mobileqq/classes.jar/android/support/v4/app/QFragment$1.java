package android.support.v4.app;

import android.view.View;

class QFragment$1
  implements QFragmentContainer
{
  QFragment$1(QFragment paramQFragment) {}
  
  public View findViewById(int paramInt)
  {
    if (this.this$0.mView == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return this.this$0.mView.findViewById(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragment.1
 * JD-Core Version:    0.7.0.1
 */