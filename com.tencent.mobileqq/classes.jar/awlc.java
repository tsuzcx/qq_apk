import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.qphone.base.util.QLog;

public class awlc
  extends GridLayoutManager.SpanSizeLookup
{
  awkr a;
  
  public awlc(awkr paramawkr)
  {
    this.a = paramawkr;
  }
  
  public int getSpanSize(int paramInt)
  {
    if (this.a == null) {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "MyLoopUp getSpanSize mAdapter == null");
    }
    while ((this.a.getItemViewType(paramInt) != 1) && (this.a.getItemViewType(paramInt) != 3)) {
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlc
 * JD-Core Version:    0.7.0.1
 */