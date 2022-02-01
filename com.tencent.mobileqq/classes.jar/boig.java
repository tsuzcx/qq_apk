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

public class boig
{
  private boib jdField_a_of_type_Boib;
  private boij jdField_a_of_type_Boij;
  
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
    if (this.jdField_a_of_type_Boib != null) {
      this.jdField_a_of_type_Boib.setOnDismissListener(new boii(this));
    }
  }
  
  public TextEditorData a(TAVCutSession paramTAVCutSession, AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    String str = bofw.a().g(paramAEEditorTextBean.fontId);
    StickerModel localStickerModel = new StickerModel();
    if (paramAEEditorTextBean.type != 2)
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
    if (this.jdField_a_of_type_Boib != null) {
      this.jdField_a_of_type_Boib.a();
    }
  }
  
  public void a(Context paramContext, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession)
  {
    if ((this.jdField_a_of_type_Boib != null) && (this.jdField_a_of_type_Boib.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Boib = new boib(paramContext, 2131755011, new boih(this, paramTextEditorData, paramTAVCutSession));
    b();
    paramContext = a(paramTextEditorData);
    this.jdField_a_of_type_Boib.a(paramContext);
    this.jdField_a_of_type_Boib.show();
  }
  
  public void a(boij paramboij)
  {
    this.jdField_a_of_type_Boij = paramboij;
  }
  
  public void a(TAVCutSession paramTAVCutSession, TextEditorData paramTextEditorData)
  {
    paramTAVCutSession.updateTextSticker(paramTextEditorData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boig
 * JD-Core Version:    0.7.0.1
 */