import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;

class bdie
  extends andd
{
  bdie(bdid parambdid) {}
  
  protected void onTroopFlagExt3Update(String paramString, long paramLong)
  {
    if ((0x40000000 & paramLong) != 0L)
    {
      bdid.a(this.a).a(EditorState.CLOSED_BY_ADMIN, bdid.a(this.a).getString(2131719699));
      return;
    }
    bdid.a(this.a).a(EditorState.OPEN_BY_ADMIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdie
 * JD-Core Version:    0.7.0.1
 */