import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

class ayxu
  implements axbz
{
  final WeakReference<SpriteVideoView> a;
  
  private ayxu(SpriteVideoView paramSpriteVideoView)
  {
    this.a = new WeakReference(paramSpriteVideoView);
  }
  
  public void a()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.a.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayxu
 * JD-Core Version:    0.7.0.1
 */