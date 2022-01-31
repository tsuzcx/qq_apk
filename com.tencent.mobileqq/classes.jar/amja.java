import com.tencent.widget.Gallery;

public class amja
  implements Runnable
{
  public amja(Gallery paramGallery) {}
  
  public void run()
  {
    Gallery.a(this.a, false);
    this.a.selectionChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amja
 * JD-Core Version:    0.7.0.1
 */