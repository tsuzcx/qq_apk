import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageViewPager;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;

public class blmw
  implements StickerOperationCallback
{
  public blmw(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onDeleteButtonClick(String paramString) {}
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerTouchEnd(String paramString)
  {
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    AEEditorImageEditFragment.a(this.a).setScrollable(true);
    this.a.jdField_a_of_type_Bdgf.removeMessages(0);
    this.a.jdField_a_of_type_Bdgf.sendEmptyMessageDelayed(0, 2000L);
  }
  
  public void onStickerTouchStart(String paramString)
  {
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    AEEditorImageEditFragment.a(this.a).setScrollable(false);
    this.a.jdField_a_of_type_Bdgf.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    this.a.jdField_a_of_type_Blpi.a(this.a.getActivity(), paramTextEditorData, AEEditorImageEditFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmw
 * JD-Core Version:    0.7.0.1
 */