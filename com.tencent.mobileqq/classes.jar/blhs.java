import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.ClipThumbnailImageView;

public class blhs
  extends RecyclerView.ViewHolder
{
  public View a;
  public ClipThumbnailImageView a;
  
  public blhs(AEEditorImageClipFragment paramAEEditorImageClipFragment, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeeditorViewClipThumbnailImageView = ((ClipThumbnailImageView)paramView.findViewById(2131377771));
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams != null)
    {
      if (!paramBoolean) {
        break label65;
      }
      localLayoutParams.height = bllm.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment.getActivity(), 50.0F);
      localLayoutParams.width = bllm.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorImageClipFragment.getActivity(), 60.0F);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      label65:
      localLayoutParams.height = 0;
      localLayoutParams.width = 0;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhs
 * JD-Core Version:    0.7.0.1
 */