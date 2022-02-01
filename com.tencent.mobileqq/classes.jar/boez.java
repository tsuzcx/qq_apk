import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageViewPager;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;

public class boez
  implements StickerOperationCallback
{
  public boez(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
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
    bnzb.a(AEEditorImageEditFragment.e(), "[onStickerOutsideClick]textEditorData = null");
  }
  
  public void onStickerSelect(TextEditorData paramTextEditorData)
  {
    if ("sticker_lyric".equals(paramTextEditorData.getStickerType()))
    {
      this.a.j();
      return;
    }
    this.a.i();
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID()));
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
  }
  
  public void onStickerTouchEnd(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0) {
      AEEditorImageEditFragment.a(this.a).setScrollable(true);
    }
    this.a.jdField_a_of_type_Bgli.removeMessages(0);
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() != 0)
    {
      AEEditorImageEditFragment.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
      this.a.jdField_a_of_type_Bgli.sendEmptyMessageDelayed(0, 2000L);
    }
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getItemID()));
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData);
  }
  
  public void onStickerTouchStart(TextEditorData paramTextEditorData)
  {
    AEEditorImageEditFragment.a(this.a).setVisibility(4);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
    AEEditorImageEditFragment.a(this.a).setScrollable(false);
    this.a.jdField_a_of_type_Bgli.removeMessages(0);
  }
  
  public void onTextEditButtonClick(TextEditorData paramTextEditorData)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      paramTextEditorData.setType(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramTextEditorData.getItemID()));
    }
    this.a.jdField_a_of_type_Boig.a(this.a.getActivity(), paramTextEditorData, AEEditorImageEditFragment.a(this.a));
  }
  
  public void onUpdateTextStickerDone(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setUniqueID(paramString);
      this.a.a(this.a.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      bnzb.d(AEEditorImageEditFragment.e(), "[onUpdateTextStickerDone] uniqueId:" + paramString);
      return;
    }
    bnzb.d(AEEditorImageEditFragment.e(), "[onUpdateTextStickerDone] mCurrentTextEditorData null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boez
 * JD-Core Version:    0.7.0.1
 */