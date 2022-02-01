package androidx.core.content.res;

import androidx.annotation.NonNull;

public final class FontResourcesParserCompat$FontFamilyFilesResourceEntry
  implements FontResourcesParserCompat.FamilyResourceEntry
{
  @NonNull
  private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;
  
  public FontResourcesParserCompat$FontFamilyFilesResourceEntry(@NonNull FontResourcesParserCompat.FontFileResourceEntry[] paramArrayOfFontFileResourceEntry)
  {
    this.mEntries = paramArrayOfFontFileResourceEntry;
  }
  
  @NonNull
  public FontResourcesParserCompat.FontFileResourceEntry[] getEntries()
  {
    return this.mEntries;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry
 * JD-Core Version:    0.7.0.1
 */