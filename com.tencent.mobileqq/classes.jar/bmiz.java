import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;

public class bmiz
  implements StickerOperationCallback
{
  public bmiz(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onAddStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(null);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.c();
    this.a.p();
    bmbx.a(AEEditorVideoEditFragment.f(), "[onDeleteButtonClick]textEditorData = null");
  }
  
  public void onStickerClick(TextEditorData paramTextEditorData)
  {
    onTextEditButtonClick(paramTextEditorData);
  }
  
  public void onStickerMoving(String paramString) {}
  
  public void onStickerOutsideClick()
  {
    this.a.j();
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    bmbx.a(AEEditorVideoEditFragment.f(), "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    this.a.i();
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID()));
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
    String str = AEEditorVideoEditFragment.f();
    StringBuilder localStringBuilder = new StringBuilder().append("[onStickerSelect]textEditorData is null ?: ");
    if (paramTextEditorData == null) {}
    for (boolean bool = true;; bool = false)
    {
      bmbx.a(str, bool);
      return;
    }
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if ("sticker_lyric".equals(paramTextEditorData.getStickerType()))
    {
      if (this.a.c()) {
        this.a.j();
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bfum.removeMessages(0);
        this.a.jdField_a_of_type_Bfum.sendEmptyMessageDelayed(0, 2000L);
        return;
        this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
      }
    }
    this.a.jdField_a_of_type_Bfum.removeMessages(0);
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
      this.a.jdField_a_of_type_Bfum.removeMessages(0);
      this.a.jdField_a_of_type_Bfum.sendEmptyMessageDelayed(0, 2000L);
    }
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    int i = this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID());
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(i);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    this.a.jdField_a_of_type_Bfum.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      paramTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData.getItemID()));
    }
    this.a.jdField_a_of_type_Bmmx.a(this.a.getActivity(), paramTextEditorData, this.a.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    if (paramTextEditorData.getType() != 3) {
      this.a.b(false);
    }
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      bmbx.d(AEEditorVideoEditFragment.f(), "[onUpdateTextStickerDone] uniqueId:" + paramString);
      return;
    }
    bmbx.d(AEEditorVideoEditFragment.f(), "[onUpdateTextStickerDone] mCurrentTextEditorData null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiz
 * JD-Core Version:    0.7.0.1
 */