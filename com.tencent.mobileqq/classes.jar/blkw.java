import android.content.Context;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;

public class blkw
{
  private blkp jdField_a_of_type_Blkp;
  private blla jdField_a_of_type_Blla;
  
  private void a()
  {
    if (this.jdField_a_of_type_Blkp != null) {
      this.jdField_a_of_type_Blkp.setOnDismissListener(new blkz(this));
    }
  }
  
  private void a(TAVCutSession paramTAVCutSession, int paramInt1, String paramString, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    TextItem localTextItem = new TextItem();
    localTextItem.text = paramString;
    localTextItem.textColor = paramInt1;
    localArrayList.add(localTextItem);
    paramString = new StickerModel();
    paramString.setAssetFilePath("ae_editor_text_main.pag");
    paramString.setCenterX(0.5F);
    paramString.setCenterY(0.6F);
    paramString.setScale(0.5F);
    paramString.setMaxScale(1.0F);
    paramString.setMinScale(0.2F);
    paramString.setTextItems(localArrayList);
    if ((paramTAVCutSession instanceof TAVCutImageSession))
    {
      ((TAVCutImageSession)paramTAVCutSession).addSticker(paramInt2, paramString);
      return;
    }
    ((TAVCutVideoSession)paramTAVCutSession).addSticker(paramString);
  }
  
  public void a(Context paramContext, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession)
  {
    if ((this.jdField_a_of_type_Blkp != null) && (this.jdField_a_of_type_Blkp.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Blkp = new blkp(paramContext, 2131755011, new blkx(this, paramTextEditorData, paramTAVCutSession));
    a();
    paramContext = new blkv();
    paramContext.a(paramTextEditorData.getTextColor());
    paramContext.a(paramTextEditorData.getContent());
    this.jdField_a_of_type_Blkp.a("default_sticker_id", paramContext);
    this.jdField_a_of_type_Blkp.show();
  }
  
  public void a(Context paramContext, TAVCutSession paramTAVCutSession, int paramInt)
  {
    if ((this.jdField_a_of_type_Blkp != null) && (this.jdField_a_of_type_Blkp.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Blkp = new blkp(paramContext, 2131755011, new blky(this, paramTAVCutSession, paramInt));
    a();
    this.jdField_a_of_type_Blkp.show();
    blen.a().j();
  }
  
  public void a(blla paramblla)
  {
    this.jdField_a_of_type_Blla = paramblla;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkw
 * JD-Core Version:    0.7.0.1
 */