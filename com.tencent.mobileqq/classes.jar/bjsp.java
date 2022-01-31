class bjsp
  implements bkjd<Boolean, bkji>
{
  bjsp(bjsn parambjsn) {}
  
  public Void a(Boolean paramBoolean, bkji parambkji)
  {
    if ((!paramBoolean.booleanValue()) || (parambkji == null) || (parambkji.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      veg.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    veg.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambkji.jdField_a_of_type_Int));
    if (parambkji.jdField_a_of_type_Int >= this.a.a.length)
    {
      veg.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambkji.jdField_a_of_type_Int) });
      return null;
    }
    veg.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambkji.jdField_a_of_type_Int));
    this.a.a[parambkji.jdField_a_of_type_Int] = bjsq.a(this.a.a[parambkji.jdField_a_of_type_Int], parambkji.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambkji.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambkji.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsp
 * JD-Core Version:    0.7.0.1
 */