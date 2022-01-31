import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.ClipThumbnailImageView;
import java.util.ArrayList;

public class blhq
  extends RecyclerView.Adapter<blhs>
{
  public blhq(AEEditorImageClipFragment paramAEEditorImageClipFragment) {}
  
  @NonNull
  public blhs a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new blhs(this.a, LayoutInflater.from(this.a.getActivity()).inflate(2131558525, paramViewGroup, false));
  }
  
  public void a(@NonNull blhs paramblhs, int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bllm.a(this.a.getActivity(), 50.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bllm.a(this.a.getActivity(), 50.0F);
    localObject = URLDrawable.getDrawable("file://" + (String)AEEditorImageClipFragment.a(this.a).get(paramInt), (URLDrawable.URLDrawableOptions)localObject);
    paramblhs.a.setImageDrawable((Drawable)localObject);
    if ((paramInt == 0) && (AEEditorImageClipFragment.c(this.a)))
    {
      paramblhs.a.setIsSelected(true);
      AEEditorImageClipFragment.c(this.a, false);
      paramblhs.a(AEEditorImageClipFragment.a(this.a)[paramInt]);
      paramblhs.a.setOnClickListener(new blhr(this, paramInt));
      return;
    }
    localObject = paramblhs.a;
    if (paramInt == AEEditorImageClipFragment.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      ((ClipThumbnailImageView)localObject).setIsSelected(bool);
      break;
    }
  }
  
  public int getItemCount()
  {
    return AEEditorImageClipFragment.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhq
 * JD-Core Version:    0.7.0.1
 */