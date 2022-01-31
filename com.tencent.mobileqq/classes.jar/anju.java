import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView;

public class anju
  implements Runnable
{
  public anju(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.a(this.a).a(this.a.getWidth(), this.a.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.a(this.a));
    }
    if (GLTextureView.a(this.a) != 1.0F) {
      GLTextureView.a(this.a, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anju
 * JD-Core Version:    0.7.0.1
 */