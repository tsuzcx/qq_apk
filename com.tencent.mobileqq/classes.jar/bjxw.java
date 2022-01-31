import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.tribe.async.reactive.SimpleObserver;

class bjxw
  extends SimpleObserver<Bitmap>
{
  bjxw(bjxv parambjxv) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    if (paramBitmap != null)
    {
      if (this.a.b)
      {
        this.a.a.setImageBitmap(paramBitmap);
        ved.b("Q.qqstory.record.EditVideoPlayer", "blur current frame success");
      }
    }
    else {
      return;
    }
    ved.d("Q.qqstory.record.EditVideoPlayer", "finish blur current frame but play-cover-view is not visible");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.d("Q.qqstory.record.EditVideoPlayer", "blur the current frame error : " + paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxw
 * JD-Core Version:    0.7.0.1
 */