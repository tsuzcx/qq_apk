import com.tencent.widget.VerticalGallery;

public class ameb
  implements Runnable
{
  public ameb(VerticalGallery paramVerticalGallery) {}
  
  public void run()
  {
    VerticalGallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ameb
 * JD-Core Version:    0.7.0.1
 */