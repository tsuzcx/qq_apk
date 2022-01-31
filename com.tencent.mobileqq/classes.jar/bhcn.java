import com.tencent.widget.AbsListView;
import cooperation.qzone.contentbox.QZoneMsgFragment;

public class bhcn
  implements bfob
{
  public bhcn(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QZoneMsgFragment.a(this.a) != null) {
      QZoneMsgFragment.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QZoneMsgFragment.a(this.a) != null) {
        QZoneMsgFragment.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      QZoneMsgFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhcn
 * JD-Core Version:    0.7.0.1
 */