import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;

class beph
  extends aofu
{
  beph(bepg parambepg) {}
  
  protected void onTroopFlagExt3Update(String paramString, long paramLong)
  {
    if ((0x40000000 & paramLong) != 0L)
    {
      bepg.a(this.a).a(EditorState.CLOSED_BY_ADMIN, bepg.a(this.a).getString(2131720152));
      return;
    }
    bepg.a(this.a).a(EditorState.OPEN_BY_ADMIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beph
 * JD-Core Version:    0.7.0.1
 */