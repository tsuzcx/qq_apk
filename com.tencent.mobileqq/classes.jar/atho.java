import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class atho
  extends bebi
{
  public atho(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.a) != null) && (FilePreviewActivity.a(this.a).isShowing())) {
      FilePreviewActivity.a(this.a).dismiss();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.a) != null) && (FilePreviewActivity.a(this.a).isShowing())) {
      FilePreviewActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atho
 * JD-Core Version:    0.7.0.1
 */