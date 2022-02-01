import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.14.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.14.2;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.Map;
import mqq.os.MqqHandler;

public class bnxp
  implements INetEngine.INetEngineListener
{
  public bnxp(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, AEEditorFilterBean paramAEEditorFilterBean, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, null);
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment) == null) {}
    while (AEEditorImageEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment)) {
      return;
    }
    if (paramNetResp.mRespData != null)
    {
      paramNetResp = AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp.mRespData, paramNetResp.reqCost, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (!TextUtils.isEmpty(paramNetResp))
      {
        paramNetResp = new bnwg(paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).put(AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean), paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
        return;
      }
      bnrh.d("AEEditorImageEditFragment", "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.14.1(this));
      return;
    }
    bnqm.a().a(paramNetResp.mErrCode, paramNetResp.reqCost + "", "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.14.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxp
 * JD-Core Version:    0.7.0.1
 */