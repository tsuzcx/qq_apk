import com.tencent.tav.core.AssetExportSession;
import com.tencent.tavcut.exporter.MovieExporter.ExportListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;

public class bnzy
  implements MovieExporter.ExportListener
{
  private long jdField_a_of_type_Long;
  private long b;
  
  public bnzy(AEEditorGenerateRunnable paramAEEditorGenerateRunnable, TAVCutVideoSession paramTAVCutVideoSession) {}
  
  public void onExportCancel()
  {
    bnrh.b("AEEditorGenerateRunnable", "onExportCancel:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportCompleted(String paramString)
  {
    this.b = System.currentTimeMillis();
    bnrh.b("AEEditorGenerateRunnable", "perf: video export cost = " + (this.b - this.jdField_a_of_type_Long) + "ms");
    bnrh.b("AEEditorGenerateRunnable", "onExportCompleted mMissionID: " + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    bnrh.b("AEEditorGenerateRunnable", "onExportCompleted exportPath: " + paramString);
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramString);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportError(AssetExportSession paramAssetExportSession)
  {
    int i = -1;
    if (paramAssetExportSession != null)
    {
      i = paramAssetExportSession.getErrCode();
      bnrh.d("AEEditorGenerateRunnable", "[onExportError] errorcode " + i);
    }
    bnrh.b("AEEditorGenerateRunnable", "onExportError:" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), i);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExportStart()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bnrh.b("AEEditorGenerateRunnable", "onExportStart :" + AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).b(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable));
    }
  }
  
  public void onExporting(float paramFloat)
  {
    if (AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable) != null) {
      AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable).a(AEEditorGenerateRunnable.a(this.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable), paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzy
 * JD-Core Version:    0.7.0.1
 */