import android.content.Context;
import android.content.Intent;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;

class arft
  implements argh
{
  arft(arfs paramarfs) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Intent localIntent = new Intent(arfw.a(arfs.a(this.a)));
    localIntent.putExtra("key_state", paramInt);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        arfs.a(this.a).sendBroadcast(localIntent);
        return;
        localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[0]).longValue());
        continue;
        paramInt = ((Integer)paramVarArgs[0]).intValue();
        localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[1]).longValue());
        localIntent.putExtra("key_progress", paramInt);
        continue;
        localIntent.putExtra("key_installedplugin", (InstalledPlugin)paramVarArgs[0]);
        if (arfw.a(arfs.a(this.a)))
        {
          argi.a("2691709");
        }
        else if (arfw.b(arfs.a(this.a)))
        {
          argi.a("2597857");
          continue;
          localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
          if (arfw.a(arfs.a(this.a)))
          {
            argi.a("2691710");
          }
          else if (arfw.b(arfs.a(this.a)))
          {
            argi.a("2597858");
            continue;
            if ("download".equals(arfs.b(this.a)))
            {
              InstalledPlugin localInstalledPlugin = (InstalledPlugin)paramVarArgs[0];
              boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
              long l = ((Long)paramVarArgs[2]).longValue();
              arfs.a(this.a, localInstalledPlugin, bool, l);
            }
            if (arfw.a(arfs.a(this.a)))
            {
              argi.a("2691703");
            }
            else if (arfw.b(arfs.a(this.a)))
            {
              argi.a("2597720");
              continue;
              localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
              if (arfw.a(arfs.a(this.a))) {
                argi.a("2691704");
              } else if (arfw.b(arfs.a(this.a))) {
                argi.a("2597721");
              }
            }
          }
        }
      }
    }
    arfs.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arft
 * JD-Core Version:    0.7.0.1
 */