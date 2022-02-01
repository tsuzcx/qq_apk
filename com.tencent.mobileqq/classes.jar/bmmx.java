import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.bean.SolidData;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bmmx
{
  private bmms jdField_a_of_type_Bmms;
  private bmna jdField_a_of_type_Bmna;
  
  private TextEditorData a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return new TextEditorData();
    }
    Map localMap = paramTextEditorData.getColorList();
    Integer localInteger = Integer.valueOf(0);
    if (!CollectionUtil.isEmptyMap(localMap)) {
      localInteger = (Integer)localMap.get("bgcolor");
    }
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    for (;;)
    {
      return new TextEditorData(paramTextEditorData.getUniqueID(), paramTextEditorData.getItemID(), paramTextEditorData.getTextColor(), paramTextEditorData.getContent(), paramTextEditorData.getPagFilePath(), paramTextEditorData.getFontPath(), localInteger.intValue());
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bmms != null) {
      this.jdField_a_of_type_Bmms.setOnDismissListener(new bmmz(this));
    }
  }
  
  public TextEditorData a(TAVCutSession paramTAVCutSession, AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    String str = bmkn.a().a(paramAEEditorTextBean.fontId, 0);
    StickerModel localStickerModel = new StickerModel();
    if ((paramAEEditorTextBean.type != 2) && (paramAEEditorTextBean.type != 3))
    {
      localObject = new ArrayList();
      TextItem localTextItem = new TextItem();
      localTextItem.text = paramAEEditorTextBean.content;
      localTextItem.textColor = paramAEEditorTextBean.textColor;
      localTextItem.fontPath = str;
      ((ArrayList)localObject).add(localTextItem);
      localStickerModel.setTextItems((List)localObject);
    }
    localStickerModel.setFilePath(paramAEEditorTextBean.pagFilePath);
    localStickerModel.setCenterX(0.5F);
    localStickerModel.setCenterY(0.5F);
    localStickerModel.setScale(paramAEEditorTextBean.scale);
    localStickerModel.setMaxScale(paramAEEditorTextBean.maxScale);
    localStickerModel.setMinScale(paramAEEditorTextBean.minScale);
    localStickerModel.setMaterialId(paramAEEditorTextBean.id);
    if (paramAEEditorTextBean.type == 3)
    {
      localStickerModel.setType("blur");
      localStickerModel.setEnableRotate(false);
      localStickerModel.setLockRatio(false);
      localStickerModel.setTexturePngPath(paramAEEditorTextBean.blurTexturePath);
      localStickerModel.setTextPngPath(paramAEEditorTextBean.blurTextPath);
    }
    Object localObject = new SolidData();
    ((SolidData)localObject).setColor(paramAEEditorTextBean.backgroundColor);
    localStickerModel.getSolidItems().put("bgcolor", localObject);
    if ((paramTAVCutSession instanceof TAVCutImageSession)) {
      ((TAVCutImageSession)paramTAVCutSession).addSticker(paramInt, localStickerModel);
    }
    for (;;)
    {
      paramTAVCutSession = new TextEditorData(localStickerModel.getUniqueId(), localStickerModel.getMaterialId(), paramAEEditorTextBean.textColor, paramAEEditorTextBean.content, paramAEEditorTextBean.pagFilePath, str, paramAEEditorTextBean.backgroundColor);
      paramTAVCutSession.setType(paramAEEditorTextBean.type);
      return paramTAVCutSession;
      ThreadManager.getUIHandler().post(new AEEditorTextPart.3(this, paramTAVCutSession, localStickerModel));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bmms != null) {
      this.jdField_a_of_type_Bmms.a();
    }
  }
  
  public void a(Context paramContext, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession)
  {
    if (paramTextEditorData.getType() == 3) {}
    while ((this.jdField_a_of_type_Bmms != null) && (this.jdField_a_of_type_Bmms.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bmms = new bmms(paramContext, 2131755011, new bmmy(this, paramTextEditorData, paramTAVCutSession));
    b();
    paramContext = a(paramTextEditorData);
    this.jdField_a_of_type_Bmms.a(paramContext);
    this.jdField_a_of_type_Bmms.show();
  }
  
  public void a(bmna parambmna)
  {
    this.jdField_a_of_type_Bmna = parambmna;
  }
  
  public void a(TAVCutSession paramTAVCutSession, TextEditorData paramTextEditorData)
  {
    paramTAVCutSession.updateTextSticker(paramTextEditorData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmx
 * JD-Core Version:    0.7.0.1
 */