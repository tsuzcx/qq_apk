import android.content.Context;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;

public class blpi
{
  private blpb jdField_a_of_type_Blpb;
  private blpm jdField_a_of_type_Blpm;
  
  private void a()
  {
    if (this.jdField_a_of_type_Blpb != null) {
      this.jdField_a_of_type_Blpb.setOnDismissListener(new blpl(this));
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
    if ((this.jdField_a_of_type_Blpb != null) && (this.jdField_a_of_type_Blpb.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Blpb = new blpb(paramContext, 2131755011, new blpj(this, paramTextEditorData, paramTAVCutSession));
    a();
    paramContext = new blph();
    paramContext.a(paramTextEditorData.getTextColor());
    paramContext.a(paramTextEditorData.getContent());
    this.jdField_a_of_type_Blpb.a("default_sticker_id", paramContext);
    this.jdField_a_of_type_Blpb.show();
  }
  
  public void a(Context paramContext, TAVCutSession paramTAVCutSession, int paramInt)
  {
    if ((this.jdField_a_of_type_Blpb != null) && (this.jdField_a_of_type_Blpb.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Blpb = new blpb(paramContext, 2131755011, new blpk(this, paramTAVCutSession, paramInt));
    a();
    this.jdField_a_of_type_Blpb.show();
    bliu.a().j();
  }
  
  public void a(blpm paramblpm)
  {
    this.jdField_a_of_type_Blpm = paramblpm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpi
 * JD-Core Version:    0.7.0.1
 */