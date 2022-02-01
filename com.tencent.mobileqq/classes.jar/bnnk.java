import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorSelectionView;

class bnnk
  extends RecyclerView.ViewHolder
{
  AEGIFTextColorSelectionView a;
  
  public bnnk(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((AEGIFTextColorSelectionView)paramView.findViewById(2131364175));
  }
  
  public void a(String paramString)
  {
    this.a.setColor(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnk
 * JD-Core Version:    0.7.0.1
 */