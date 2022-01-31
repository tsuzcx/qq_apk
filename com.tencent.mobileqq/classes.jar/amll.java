import com.tencent.widget.VerticalGallery;

public class amll
  implements Runnable
{
  public amll(VerticalGallery paramVerticalGallery) {}
  
  public void run()
  {
    VerticalGallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amll
 * JD-Core Version:    0.7.0.1
 */